package ru.job4j.ood.isp.menu;

import java.util.Scanner;

/**
 * 6. Создайте простенький класс TodoApp. Этот класс будет представлять собой консольное приложение, которое позволяет:
 * Добавить элемент в корень меню;
 * Добавить элемент к родительскому элементу;
 * Вызвать действие, привязанное к пункту меню (действие можно сделать константой,
 * например, ActionDelete DEFAULT_ACTION = () -> System.out.println("Some action") и указывать при добавлении элемента в меню);
 * Вывести меню в консоль.
 */
public class TodoApp {
    private static final String NEW_TASK = "Add new task";
    private static final String NEW_CHILD_TASK = "Add new child task";
    private static final String SHOW_ALL_TASKS = "Show all tasks";
    private static final String EXIT = "Exit";
    private static final int ADD_NEW_TASK = 1;
    private static final int ADD_NEW_CHILD_TASK = 2;
    private static final int PRINT_ALL_TASKS = 3;
    private static final int QUIT = 4;

    private final Menu menu;
    private final Scanner scanner;
    private final MenuPrinter menuPrinter;

    public TodoApp(Menu menu, Scanner scanner, MenuPrinter menuPrinter) {
        this.menu = menu;
        this.scanner = scanner;
        this.menuPrinter = menuPrinter;
    }

    public static void main(String[] args) {
        Scanner menuScanner = new Scanner(System.in);
        Menu menu = new SimpleMenu();
        MenuPrinter printer = new MenuPrint();
        TodoApp todoApp = new TodoApp(menu, menuScanner, printer);
        menu.add(Menu.ROOT, NEW_TASK, new ActionAddTask(menu, menuScanner));
        menu.add(Menu.ROOT, NEW_CHILD_TASK, new ActionAddNewChildTask(menu, menuScanner));
        menu.add(Menu.ROOT, SHOW_ALL_TASKS, new ActionPrint(menu));
        menu.add(Menu.ROOT, EXIT, new ActionExit());

        todoApp.init();
    }

    private void init() {
        boolean run = true;
        while (run) {
            menuPrinter.print(menu);
            System.out.println("Pick action: ");
            int i = Integer.parseInt(scanner.nextLine());
            if (i == ADD_NEW_TASK) {
                executeChoice(NEW_TASK);
            } else if (i == ADD_NEW_CHILD_TASK) {
                executeChoice(NEW_CHILD_TASK);
            } else if (i == PRINT_ALL_TASKS) {
                executeChoice(SHOW_ALL_TASKS);
            } else if (i == QUIT) {
                executeChoice(EXIT);
                run = false;
            }
        }
    }

    private void executeChoice(String choice) {
        menu.select(choice).get().getActionDelegate().delegate();
    }
}
