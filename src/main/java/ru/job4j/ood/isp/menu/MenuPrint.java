package ru.job4j.ood.isp.menu;

public class MenuPrint implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        menu.forEach(i -> {
            int count = i.getNumber().split("\\.").length - 1;
            String text = " ";
            for (int j = 0; j < count; j++) {
                text = String.format("%s%s", "---", text);
            }
            System.out.println(text + i.getNumber() + i.getName());
        });
    }
}
