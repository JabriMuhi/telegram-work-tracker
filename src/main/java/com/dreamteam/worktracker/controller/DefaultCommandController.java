package com.dreamteam.worktracker.controller;

import com.dreamteam.worktracker.telegram.Bot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface DefaultCommandController {
    BotApiMethod<?> start(Message message, Bot bot);
    BotApiMethod<?> help(Message message, Bot bot);

}
