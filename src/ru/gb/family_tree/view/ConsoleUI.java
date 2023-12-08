package ru.gb.family_tree.view;

import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View {
    private final MainMenu menu;
    private final Scanner scanner;
    private final Presenter presenter;
    private boolean work;

    public ConsoleUI() {
        menu = new MainMenu(this);
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }

    @Override
    public void start() {

        presenter.start();
        System.out.println("Приветствие");

        while (work) {
            System.out.println(menu.menu());
            int menuCount = (int)inputPositiveLong("Ваш выбор: ");
            menu.choice(menuCount);
        }
    }

    public void finish() {
        work = false;
        presenter.finish();
    }
    public void addHuman() {
        System.out.println("Добавление человека");
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите пол (жен, муж): ");
        String gender = scanner.nextLine();

        LocalDate birthDate = inputDate("Введите дату рождения (dd.mm.yyyy): ");
        long matherId = inputPositiveLong("Введите id матери: ");
        long fatherId = inputPositiveLong("Введите id отца: ");

        presenter.addHuman(name, gender, birthDate, matherId, fatherId);
    }

    private LocalDate inputDate(String inputMessage) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        while(true) {
            System.out.print(inputMessage);
            String input = scanner.nextLine();
            try {
                return LocalDate.parse(input, formatter);
            } catch (Exception e) {
                System.out.println("Неверный формат даты");
            }
        }
    }

    private long inputPositiveLong(String inputMessage) {
        while(true) {
            System.out.print(inputMessage);
            try {
                return Long.parseLong(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Требуется ввести целое положительное число");
            }
        }
    }
    public void sortByName() {
        presenter.sortByName();
        presenter.getHumanListInfo();
    }

    public void sortByAge() {
        presenter.sortByAge();
        presenter.getHumanListInfo();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

}
