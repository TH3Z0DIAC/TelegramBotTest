package ch.nyplj.telebot;

import ch.nyplj.telebot.bot.Bot;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SetWebhook;
import com.pengrad.telegrambot.response.BaseResponse;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Bot bot = new Bot("1364220505:AAGPZNlO5i_7yxOMTu8_qcbZxgGEh7DNt-Y");

        SetWebhook request = new SetWebhook()
                .url("url").certificate(new byte[]{});


        BaseResponse response = bot.execute(request);
        System.out.println(response.isOk());
    }

}
