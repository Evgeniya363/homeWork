package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public abstract class Command {
    private final String description;
    private final ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
// getConsoleUI без модификатора доступа: область видимости - пакет
    ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public abstract void execute();
}
