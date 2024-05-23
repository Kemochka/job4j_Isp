package ru.job4j.ood.isp.menu;

public class ActionPrint implements ActionDelegate {
    private final Menu menu;

    public ActionPrint(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void delegate() {
        menu.forEach(i -> {
            int count = i.getName().split("\\.").length;
            if (count > 1) {
                System.out.println(i.getNumber().substring(2) + i.getName());
            }
        });
    }
}
