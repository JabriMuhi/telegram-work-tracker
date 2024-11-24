package com.dreamteam.worktracker.utility;

import com.dreamteam.worktracker.controller.DefaultCommandController;
import com.dreamteam.worktracker.telegram.Bot;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UpdateDispatcher {
    private DefaultCommandController defaultCommandsController;

    public BotApiMethod<?> distribute(Update update, Bot bot) {
        if(update.hasMessage()) {
            Message message = update.getMessage();
            if(message.hasText()) {
                String text = message.getText();
                if (text.charAt(0) == '/') {
                    return findController(message, bot);
                }
            }
        }
        return null;
    }

    private BotApiMethod<?> findController(Message message, Bot bot) {
        return switch(message.getText()) {
            case "/start" -> defaultCommandsController.start(message, bot);
            case "/help" -> defaultCommandsController.help(message, bot);
            default -> SendMessage.builder()
                    .chatId(message.getChat().getId())
                    .text("Неизвестная команда.")
                    .build();
        };
    }
}