package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.*;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    protected String getServerAddress() {   //должен запросить ввод адреса сервера у пользователя и вернуть введенное значение
        return ConsoleHelper.readString();
    }

    protected int getServerPort() throws IOException {          //должен запрашивать ввод порта сервера и возвращать его
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {                 //должен запрашивать и возвращать имя пользователя
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            e.printStackTrace();
            ConsoleHelper.writeMessage("Не удалось отправить сообщение серверу");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);       //Помечать созданный поток как daemon, это нужно для того, чтобы при выходе из программы вспомогательный поток прервался автоматически.
        socketThread.start();
        String line = "";
        synchronized (this) {
            try {
                wait();

            } catch (InterruptedException e) {
                //e.printStackTrace();
                ConsoleHelper.writeMessage("Error");
            }
            if (clientConnected) {      //true
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
                while (clientConnected) {       //true
                    line = ConsoleHelper.readString();

                    if (line.equals("exit"))
                        break;
                    if (shouldSendTextFromConsole())        //true
                        sendTextMessage(line);
                }

            } else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");


        }
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(String.format(" Пользователь %s присоединился к чату", userName));
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(String.format("Пользователь %s покинул чат", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message serverMessage = connection.receive();          //сообщение от сервера
                String userName;
                if (serverMessage.getType() == MessageType.NAME_REQUEST) {       //сервер запросил имя
                    userName = getUserName();                                     //ввод имени пользователя
                    connection.send(new Message(MessageType.USER_NAME, userName));  //сообщение с типом MessageType.USER_NAME и введенным именем отправляем серверу
                } else if (serverMessage.getType() == MessageType.NAME_ACCEPTED) {        //сервер принял имя
                    notifyConnectionStatusChanged(true);        //сервер принял имя клиента, об этом сообщаем главному потоку
                    break;
                } else
                    throw new IOException("Unexpected MessageType");     //кидаем исключение,если сообщение другого типа
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message serverMessage = connection.receive();          //сообщение от сервера
                if (serverMessage.getType() == MessageType.TEXT)       //MessageType.TEXT
                    processIncomingMessage(serverMessage.getData());

                else if (serverMessage.getType() == MessageType.USER_ADDED)     //MessageType.USER_ADDED
                    informAboutAddingNewUser(serverMessage.getData());

                else if (serverMessage.getType() == MessageType.USER_REMOVED)      //MessageType.USER_REMOVED
                    informAboutDeletingNewUser(serverMessage.getData());

                else throw new IOException("Unexpected MessageType");
            }
        }

        public void run() {
            String serverAddress = getServerAddress();
            try {
                int serverPort = getServerPort();
                Socket socket = new Socket(serverAddress, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                //e.printStackTrace();
                notifyConnectionStatusChanged(false);
            }


        }
    }
}
