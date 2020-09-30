package ch.nyplj.telebot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Main {

    public static final String BOT_TOKEN = "1364220505:AAGPZNlO5i_7yxOMTu8_qcbZxgGEh7DNt-Y";
    public static final String BOT_NAME = "FncyRainbowBot";

    public static void main(String[] args) {
        // Initializes API Context that can be used later on
        ApiContextInitializer.init();
        // New Connection to TelegramBot API
        TelegramBotsApi api = new TelegramBotsApi();

        try {
            // Register new Bot
            // IMPORTANT: Bot has to be in same package as Main (Protected Access Constructor)
            //  -> or Change Constructor Access Modifier to Public
            api.registerBot(new Bot(BOT_TOKEN, BOT_NAME));

            // ignored -> no warning that catch is empty
        } catch (TelegramApiRequestException ignored) {

        }


    }

}
