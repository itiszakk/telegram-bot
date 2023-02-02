package com.itiszakk.telegrambot.command.custom;

import com.itiszakk.telegrambot.command.ExecutableCustomCommand;

public class StartCommand extends ExecutableCustomCommand {

    public StartCommand() {
        super("/start", "Запустить бота");
    }

    @Override
    public void execute() {
        System.out.println(super.toString());
    }
}
