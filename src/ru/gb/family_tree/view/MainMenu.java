package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commandList;
    public MainMenu(ConsoleUI consoleUI){
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new GetHumanListInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder sb = new StringBuilder("Меню:\n");
        for (int i = 1; i <= commandList.size() ; i++) {
            sb.append(i);
            sb.append(". ");
            sb.append(commandList.get(i - 1).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void choice(int index) {
        if (index < size()) {
            Command command = commandList.get(index-1);
            command.execute();
        }
    }

    private long size() {
        return  commandList.size();
    }
}
