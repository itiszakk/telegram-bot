package com.itiszakk.telegrambot.command;

import com.itiszakk.telegrambot.command.custom.CategoryCommand;
import com.itiszakk.telegrambot.command.custom.StartCommand;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomCommandService {

    private final Map<String, ExecutableCustomCommand> commandMap;

    public CustomCommandService() {
        commandMap = new HashMap<>();

        addCustomCommand(new StartCommand());
        addCustomCommand(new CategoryCommand());
    }

    public void executeCommand(String command) {
        if (!commandMap.containsKey(command)) {
            return;
        }

        commandMap.get(command).execute();
    }

    public List<BotCommand> getBotCommands() {
        return commandMap.values().stream()
                .map(command -> (BotCommand) command)
                .toList();
    }

    private void addCustomCommand(ExecutableCustomCommand command) {
        commandMap.put(command.getCommand(), command);
    }
}
