package com.itiszakk.telegrambot.command.custom;

import com.itiszakk.telegrambot.command.ExecutableCustomCommand;

public class CategoryCommand extends ExecutableCustomCommand {

    public CategoryCommand() {
        super("/category", "Получить все категории");
    }

    @Override
    public void execute() {
        System.out.println(super.toString());
    }
}
