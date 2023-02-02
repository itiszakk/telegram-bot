package com.itiszakk.telegrambot.command;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

public abstract class ExecutableCustomCommand extends BotCommand implements Executable {

    public ExecutableCustomCommand(String command, String description) {
        super(command, description);
    }
}
