package com.itiszakk.telegrambot.bot;

import com.itiszakk.telegrambot.command.CustomCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Slf4j
@Service
public class BotService extends TelegramLongPollingBot {

    private final BotConfig config;
    private final CustomCommandService commandService;

    @Autowired
    public BotService(BotConfig config, CustomCommandService commandService) {
        this.config = config;
        this.commandService = commandService;

        List<BotCommand> botCommands = commandService.getBotCommands();

        try {
            this.execute(new SetMyCommands(botCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public String getBotUsername() {
        return config.getUsername();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage()) {
            return;
        }

        if (!update.getMessage().hasText()) {
            return;
        }

        String messageText = update.getMessage().getText();

        if (messageTextIsCommand(messageText)) {
            commandService.executeCommand(messageText);
        }
    }

    private boolean messageTextIsCommand(String text) {
        return text.charAt(0) == '/';
    }
}
