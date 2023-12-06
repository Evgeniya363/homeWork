package ru.gb.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.service.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args)  {
        Service service = new Service();
        service.start();
        service.read();
//       service.initialization();
        service.sortByAge();
        System.out.println(service.getHumanInfo());
        service.save();
    }
}
