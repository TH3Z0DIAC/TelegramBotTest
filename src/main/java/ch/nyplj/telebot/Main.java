package ch.nyplj.telebot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static ch.nyplj.telebot.BotInformation.*;

public class Main {

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


            //Notification that Bot has been started
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request;

            for (Long chatId : CHAT_IDS) {
                request = HttpRequest.newBuilder()
                        // CHATID CHANGE
                        .uri(URI.create("https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage?chat_id=" + MY_CHAT_ID + "&text=" + PRETTY_BOT_NAME + "%20wurde%20gestartet!"))
                        .build();

                client.send(request, HttpResponse.BodyHandlers.ofString());
            }

            Scanner scanner = new Scanner(System.in);
            do {
                if(scanner.hasNextLine()) {
                    if(scanner.nextLine().equalsIgnoreCase("stop bot")) {

                        for (Long chatId : CHAT_IDS) {
                            request = HttpRequest.newBuilder()
                                    // CHATID CHANGE
                                    .uri(URI.create("https://api.telegram.org/bot" + BOT_TOKEN + "/sendMessage?chat_id=" + MY_CHAT_ID + "&text=" + PRETTY_BOT_NAME + "%20wird%20heruntergefahren!"))
                                    .build();

                            client.send(request, HttpResponse.BodyHandlers.ofString());
                        }

                        System.exit(0);
                    }
                }
            } while (true);

            // ignored -> no warning that catch is empty
        } catch (TelegramApiRequestException ignored) {

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

}
