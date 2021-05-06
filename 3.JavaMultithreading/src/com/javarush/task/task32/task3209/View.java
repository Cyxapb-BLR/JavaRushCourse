package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();     //будет панель с двумя вкладками
    private JTextPane htmlTextPane = new JTextPane();     //компонент для визуального редактирования html. Он будет размещен на первой вкладке.
    private JEditorPane plainTextPane = new JEditorPane();  //компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое).
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public View() throws HeadlessException {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }


    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init() {            //отвечает за инициализацию представления.
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);

    }

    public void exit() {
        controller.exit();
    }

    public void initMenuBar() {     //отвечает за инициализацию меню
        JMenuBar menuBar = new JMenuBar();              //панель меню
        //С помощью MenuHelper инициализировать меню в следующем порядке: Файл, Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
        MenuHelper.initFileMenu(this, menuBar);     //Файл
        MenuHelper.initEditMenu(this, menuBar);     //Редактировать
        MenuHelper.initStyleMenu(this, menuBar);     //Стиль
        MenuHelper.initAlignMenu(this, menuBar);     //Выравнивание
        MenuHelper.initColorMenu(this, menuBar);     //Цвет
        MenuHelper.initFontMenu(this, menuBar);      //Шрифт
        MenuHelper.initHelpMenu(this, menuBar);      //Помощь
        getContentPane().add(menuBar, BorderLayout.NORTH);  /*Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню,
                                                                     аналогично тому, как это мы делали с панелью вкладок.*/


    }

    public void initEditor() {       //отвечает за инициализацию панелей редактора.
        htmlTextPane.setContentType("text/html");                   //Устанавливать значение "text/html" в качестве типа контента для компонента htmlTextPane.
        JScrollPane htmlTab = new JScrollPane(htmlTextPane);     //Создавать новый локальный компонент JScrollPane на базе htmlTextPane.
        tabbedPane.addTab("HTML", htmlTab);                 //Добавлять вкладку в панель tabbedPane с именем "HTML" и компонентом из предыдущего пункта.
        JScrollPane textTab = new JScrollPane(plainTextPane);   //Создавать новый локальный компонент JScrollPane на базе plainTextPane.
        tabbedPane.addTab("Текст", textTab);                //Добавлять еще одну вкладку в tabbedPane с именем "Текст" и компонентом из предыдущего пункта.
        tabbedPane.setPreferredSize(getPreferredSize());        //Устанавливать предпочтительный размер панели tabbedPane.
        TabbedPaneChangeListener listener = new TabbedPaneChangeListener(this); // Создавать объект класса TabbedPaneChangeListener и
        tabbedPane.addChangeListener(listener);                                     //устанавливать его в качестве слушателя изменений в tabbedPane.
        getContentPane().add(tabbedPane, BorderLayout.CENTER);                   //Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
    }

    public void initGui() {         //инициализирует графический интерфейс
        initMenuBar();
        initEditor();
        pack();
    }

    //Будет вызваться при выборе пунктов меню, у которых наше представление указано в виде слушателя событий.
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String actionCommand = actionEvent.getActionCommand();      //Получи из события команду

            switch (actionCommand) {
                case "Новый":
                    controller.createNewDocument();
                    break;
                case "Открыть":
                    controller.openDocument();
                    break;
                case "Сохранить":
                    controller.saveDocument();
                    break;
                case "Сохранить как...":
                    controller.saveDocumentAs();
                    break;
                case "Выход":
                    controller.exit();
                    break;
                case "О программе":
                    showAbout();
                    break;
            }

    }

    public void selectedTabChanged() {      //метод вызывается, когда произошла смена выбранной вкладки
        if (tabbedPane.getSelectedIndex() == 0)
            controller.setPlainText(plainTextPane.getText());   //Если выбрана вкладка с индексом 0 (html вкладка),
            // значит нам нужно получить текст из plainTextPane и установить его в контроллер с помощью метода setPlainText
        else if (tabbedPane.getSelectedIndex() == 1)
            plainTextPane.setText(controller.getPlainText());
        resetUndo();
    }

    public void undo() {        //отменяет последнее действие.
        try {
            undoManager.undo();     //Реализуй его используя undoManager. Метод не должен кидать исключений, логируй их.
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }

    }

    public void redo() {        // возвращает ранее отмененное действие.
        try {
            undoManager.redo();     //Реализуй его используя undoManager. Метод не должен кидать исключений, логируй их.
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo() {
        undoManager.discardAllEdits();      //должен сбрасывать все правки в менеджере undoManager.
    }

    public boolean canUndo() {

        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        HTMLDocument document = controller.getDocument();
        htmlTextPane.setDocument(document);
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(null, "Подробнее", "About", JOptionPane.INFORMATION_MESSAGE);
        int informationMessage = JOptionPane.INFORMATION_MESSAGE;
    }
}
