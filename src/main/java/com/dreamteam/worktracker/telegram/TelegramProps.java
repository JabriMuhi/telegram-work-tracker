package com.dreamteam.worktracker.telegram;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class TelegramProps {
    @Value("${TELEGRAM_TOKEN}")
    String token;

    @Value("${TELEGRAM_NAME}")
    String name;
}