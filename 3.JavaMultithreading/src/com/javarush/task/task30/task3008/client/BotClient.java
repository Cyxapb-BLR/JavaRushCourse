package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotClient extends Client {
    @Override
    protected String getUserName() {
        return String.format("date_bot_%s", (int) (Math.random() * 100));      //новое имя бота, например: date_bot_X, где X - любое число от 0 до 99
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);        //Вывести в консоль текст полученного сообщения message
            if (message != null && message.contains(": ")) {
                String[] messageArray = new String[2];
                messageArray = message.split(": ");    //Получить из message имя отправителя и текст сообщения. Они разделены ": "
                String userName = messageArray[0];
                String userMessage = messageArray[1];
                DateFormat dateFormat = null;
                switch (userMessage) {
                    case "дата":
                        dateFormat = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        dateFormat = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        dateFormat = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        dateFormat = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        dateFormat = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        dateFormat = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        dateFormat = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        dateFormat = new SimpleDateFormat("s");
                        break;
                    default:
                        return;
                }
                Date date = new GregorianCalendar().getTime();
                sendTextMessage(String.format("Информация для %s: %s", userName, dateFormat.format(date)));     // Отправить ответ в зависимости от текста принятого сообщения
            }
        }
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}
