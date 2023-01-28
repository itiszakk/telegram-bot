package com.itiszakk.telegrambot.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/telegram.properties")
@Getter
public class BotConfig {

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;
}
