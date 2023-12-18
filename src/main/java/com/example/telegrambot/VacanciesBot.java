package com.example.telegrambot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class VacanciesBot extends TelegramLongPollingBot {
    //6908147099:AAH1wHfUgQjWEjusT13EAqNMTqjesn_dHEY


    public VacanciesBot() {
        super("6908147099:AAH1wHfUgQjWEjusT13EAqNMTqjesn_dHEY");
    }

    @Override
    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        System.out.println("Received text is " + text);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText("Your message '" + text + "' was received!");
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getBotUsername() {
        return "gunnar vacancies bot";
    }
}
