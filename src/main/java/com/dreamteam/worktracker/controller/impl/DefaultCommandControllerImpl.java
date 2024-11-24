package com.dreamteam.worktracker.controller.impl;

import com.dreamteam.worktracker.controller.DefaultCommandController;
import com.dreamteam.worktracker.telegram.Bot;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Controller
public class DefaultCommandControllerImpl implements DefaultCommandController {
    @Override
    public BotApiMethod<?> start(Message message, Bot bot) {
        return SendMessage.builder()
                .chatId(message.getChat().getId())
                .text("Start")
                .build();
    }

    @Override
    public BotApiMethod<?> help(Message message, Bot bot) {
        return SendMessage.builder()
                .chatId(message.getChat().getId())
                .text("help")
                .build();
    }
}
