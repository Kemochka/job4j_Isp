package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class ActionAddNewChildTask implements ActionDelegate {
    private static final ActionDelegate ADD = () -> System.out.println("Task has been added");
    private final Menu menu;
    private final Scanner scanner;

    public ActionAddNewChildTask(Menu menu, Scanner scanner) {
        this.menu = menu;
        this.scanner = scanner;
    }

    @Override
    public void delegate() {
        System.out.println("Enter parent task name");
        String parentTaskName = scanner.nextLine();
        System.out.println("Enter new task name");
        String childTaskName = scanner.nextLine();
        menu.add(parentTaskName, childTaskName, ADD);
    }
}
