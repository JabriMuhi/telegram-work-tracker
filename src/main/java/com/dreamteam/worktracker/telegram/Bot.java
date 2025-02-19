package com.dreamteam.worktracker.telegram;

import com.dreamteam.worktracker.utility.UpdateDispatcher;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {
    TelegramProps telegramProps;
    UpdateDispatcher updateDispatcher;

    public Bot(TelegramProps telegramProps, UpdateDispatcher updateDispatcher) {
        super(telegramProps.getToken());
        this.telegramProps = telegramProps;
        this.updateDispatcher = updateDispatcher;
    }

    @Override
    public String getBotUsername() {
        return telegramProps.getName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            execute(updateDispatcher.distribute(update, this));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
