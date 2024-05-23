package ru.job4j.ood.isp.menu;

public class ActionExit implements ActionDelegate {
    @Override
    public void delegate() {
        System.out.println("Goodbye!");
    }
}
