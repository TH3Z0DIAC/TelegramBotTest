package ch.nyplj.telebot.bot;


import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

import static org.telegram.abilitybots.api.objects.Locality.USER;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class Bot extends AbilityBot {

    protected Bot(String botToken, String botUsername) {
        super(botToken, botUsername);
    }

    @Override
    public int creatorId() {
        return 434;
    }

    public Ability saysHelloWorld() {
        return Ability.builder()
                .name("hello")
                .privacy(PUBLIC)
                .locality(USER)
                .input(0) // How many arguments command needs
                .action(msgContext -> silent.send("HELLO WORLD", msgContext.chatId()))
                .build();
    }

}
