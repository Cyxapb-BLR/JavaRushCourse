package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Connection value : connectionMap.values()) {
            try {
                value.send(message);
            } catch (IOException e) {
                //e.printStackTrace();
                try {
                    value.send(new Message(MessageType.TEXT, "Не смогли отправить сообщение"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        }
    }

    private static class Handler extends Thread {
        Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String receiveName = null;
            try {
                while (true) {
                    connection.send(new Message(MessageType.NAME_REQUEST, "Введите имя"));
                    Message receiveMessage = connection.receive();
                    receiveName = receiveMessage.getData();
                    if (receiveMessage.getType().equals(MessageType.USER_NAME) && !receiveName.isEmpty() && !connectionMap.containsKey(receiveName)) {
                        connectionMap.put(receiveName, connection);
                        break;
                    }
                }
                connection.send(new Message(MessageType.NAME_ACCEPTED, "Пользователь " + receiveName + " добавлен в чат"));
                return receiveName;

            } catch (IOException | ClassNotFoundException e) {
                //e.printStackTrace();
                serverHandshake(connection);
            }
            return receiveName;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String user : connectionMap.keySet()) {
                if (!user.equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, user));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {

            while (true) {
                Message receiveMessage = connection.receive();
                if (receiveMessage.getType() == MessageType.TEXT) {
                    Message newMessage = new Message(MessageType.TEXT, String.format("%s: %s", userName, receiveMessage.getData()));
                    sendBroadcastMessage(newMessage);
                } else ConsoleHelper.writeMessage("Принятое сообщение не является текстом");
            }
        }

        public void run() {
            System.out.println(socket.getRemoteSocketAddress());    //установлено новое соединение с удаленным адресом

            String userName = null;
            try (Connection connection = new Connection(socket) ) {

                userName = serverHandshake(connection);  //имя нового клиента
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);               // Рассылать всем участникам чата информацию об имени присоединившегося участника
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                //e.printStackTrace();
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом");
            }
            if (userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int serverPort = ConsoleHelper.readInt();
        try (
                java.net.ServerSocket serverSocket = new ServerSocket(serverPort);
        ) {
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
