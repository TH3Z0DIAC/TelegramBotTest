package ch.nyplj.telebot;


import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

import static org.telegram.abilitybots.api.objects.Locality.USER;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class Bot extends AbilityBot {

    /**
     *
     * @param botToken token given by BotFather
     * @param botUsername username given to Bot by BotFather
     */
    protected Bot(String botToken, String botUsername) {
        super(botToken, botUsername);
    }

    // Not important yet, but has to be implemented
    @Override
    public int creatorId() {
        return 434;
    }

    // Method that answers "HELLO WORLD" to command /hello
    public Ability saysHelloWorld() {
        return Ability.builder() // Starting to build an ability (of the bot)
                .name("hello") // What comes after the command token / - "slash"
                .privacy(PUBLIC) // Privacy of the Command
                .locality(USER) // Who can use the command (in this case just users, no groups etc. )
                .input(0) // How many arguments command needs
                // Silently (without logging) sending message -> needs ChatID to know to whom to send the message
                // ChatID is given by msgContext (can be renamed)
                .action(msgContext -> silent.send("HELLO WORLD", msgContext.chatId()))
                .build();
    }

}
