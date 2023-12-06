package ru.gb.family_tree;

import ru.gb.family_tree.service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args)  {
        Service service = new Service();
        service.read();
//        service.initialization();
//        Human andrey = service.addHuman("Andrey", Gender.Male, LocalDate.of(1971,10,29));
//        Human sasha = service.addHuman("Alexandra", Gender.Female, LocalDate.of(1997,10,21));
//        service.appendChild(andrey, sasha);
        service.sortByAge();
        System.out.println(service.getHumanInfo());
        service.save();
    }
}
