package ch.nyplj.telebot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import static ch.nyplj.telebot.BotInformation.BOT_NAME;
import static ch.nyplj.telebot.BotInformation.BOT_TOKEN;

public class Main {

//    public static final String BOT_TOKEN = "1310849219:AAHDGvg_dhS7zE9tNqYp4seFw48Lu63uMxg";
//    public static final String BOT_NAME = "ronjaK_bot";

    public static void main(String[] args) {
        // Initializes API Context that can be used later on
        ApiContextInitializer.init();


        // New Connection to TelegramBot API
        TelegramBotsApi api = new TelegramBotsApi();

        try {
            // Register new Bot
            // IMPORTANT: Bot has to be in same package as Main (Protected Access Constructor)
            //  -> or Change Constructor Access Modifier to Public
            Bot bot = new Bot(BOT_TOKEN, BOT_NAME);
            api.registerBot(bot);


            // ignored -> no warning that catch is empty
        } catch (TelegramApiRequestException ignored) {

        }

    }

}
