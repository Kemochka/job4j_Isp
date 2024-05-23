package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class ActionAddTask implements ActionDelegate {
    private static final ActionDelegate ADD = () -> System.out.println("Task has been added");
    private final static String TASKS = "Show all tasks";
    private final Menu menu;
    private final Scanner scanner;

    public ActionAddTask(Menu menu, Scanner scanner) {
        this.menu = menu;
        this.scanner = scanner;
    }

    @Override
    public void delegate() {
        System.out.println("Enter task name");
        String taskName  = scanner.nextLine();
        menu.add(TASKS, taskName, ADD);
    }
}
