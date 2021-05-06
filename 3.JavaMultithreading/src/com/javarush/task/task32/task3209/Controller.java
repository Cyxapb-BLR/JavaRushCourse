package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public HTMLDocument getDocument() {     //должен получать документ у контроллера и устанавливать его в панель редактирования htmlTextPane.
        return document;
    }

    public Controller(View view) {
        this.view = view;
    }

    public void init() {            //отвечает за инициализацию контроллера
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public void resetDocument() {       //будет сбрасывать текущий документ
        if (document != null)
            document.removeUndoableEditListener(view.getUndoListener());        //Удалять у текущего документа document слушателя правок, которые можно отменить/вернуть
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();  //Создавать новый документ по умолчанию и присваивать его полю document.
        document.addUndoableEditListener(view.getUndoListener());               //Добавлять новому документу слушателя правок.
        view.update();                                                          //Вызывать у представления метод update().
    }

    public void setPlainText(String text) {                     //будет записывать переданный текст с html тегами в документ document
        resetDocument();                                        //Сбрось документ
        StringReader stringReader = new StringReader(text);     //Создай новый ридер StringReader на базе переданного текста.
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.read(stringReader, document, 0);  //Метод setPlainText(String text) должен вызывать метод read() у объекта HTMLEditorKit.
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter stringWriter = new StringWriter();                                 //Создай объект StringWriter.
        try {
            int length = document.getLength();
            new HTMLEditorKit().write(stringWriter, document, 0, length); //Перепиши все содержимое из документа document в созданный объект с помощью метода write класса HTMLEditorKit
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }


    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void createNewDocument() {
        view.selectHtmlTab();               // Выбирать html вкладку у представления.
        resetDocument();                    // Сбрасывать текущий документ.
        view.setTitle("HTML редактор");     // Устанавливать новый заголовок окна
        currentFile = null;                 // Обнулить переменную currentFile
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        if (fileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());

            try (FileReader fileReader = new FileReader(currentFile)) {
                new HTMLEditorKit().read(fileReader, document, 0);
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }

            view.resetUndo();
        }
    }

    public void saveDocument() {
        view.selectHtmlTab();
        if (currentFile != null) {
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (BadLocationException | IOException e) {
                ExceptionHandler.log(e);
            }
        } else saveDocumentAs();
    }

    public void saveDocumentAs() {                          //Реализуем в контроллере метод для сохранения файла под новым именем
        view.selectHtmlTab();                               //Переключать представление на html вкладку.
        JFileChooser jFileChooser = new JFileChooser();     // Создавать новый объект для выбора файла JFileChooser.
        jFileChooser.setFileFilter(new HTMLFileFilter());   //Устанавливать ему в качестве фильтра объект HTMLFileFilter.
        int i = jFileChooser.showSaveDialog(view);          //Показывать диалоговое окно "Save File" для выбора файла.
        if (i == JFileChooser.APPROVE_OPTION) {
            currentFile = jFileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try (FileWriter fileWriter = new FileWriter(currentFile)) {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

}
