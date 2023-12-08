package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.service.ServiceHuman;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private final View view;
    private final ServiceHuman service;

    public Presenter(View view) {
        this.view = view;
        service = new ServiceHuman();
    }
    public boolean start() {
        return service.read();
    }

    public boolean finish() {
        return service.save();
    }

    public void addHuman(String name, String gender, LocalDate birthDate, Long matherId, Long fatherId){
        service.addHuman(name, gender, birthDate, matherId, fatherId);
    }
    public void getHumanListInfo() {
        String answer = service.getHumanInfo();
        view.printAnswer(answer);
    }
    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByAge();
    }
}
