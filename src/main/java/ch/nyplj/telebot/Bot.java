package ch.nyplj.telebot;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.MessageContext;

import java.nio.charset.StandardCharsets;

import static org.telegram.abilitybots.api.objects.Locality.USER;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class Bot extends AbilityBot {
    private final int CREATOR_ID = 1252376620;
    private java.util.function.Consumer<MessageContext> Consumer;
    private Object MessageContext;

    /**
     * Basic Bot Constructor
     * @param botToken token given by BotFather
     * @param botUsername username given to Bot by BotFather
     */
    protected Bot(String botToken, String botUsername) {
        super(botToken, botUsername);
    }

    // Not important yet, but has to be implemented
    @Override
    public int creatorId() {
        return CREATOR_ID;
    }

    // Method that answers "HELLO WORLD" to command /hello
    public Ability saysHelloWorld() {
        return Ability.builder() // Starting to build an ability (of the bot)
                .name("hello") // What comes after the command token / - "slash"
                .info("Says hello world") // Information given when used /commands
                .privacy(PUBLIC) // Privacy of the Command
                .locality(USER) // Who can use the command (in this case just users, no groups etc. )
                .input(0) // How many arguments command needs
                // Silently (without logging) sending message -> needs ChatID to know to whom to send the message
                // ChatID is given by msgContext (can be renamed)
                .action(msgContext -> silent.send("HELLO MY WORLD", msgContext.chatId()))
                .build();
    }

    public Ability saysGoodBye() {
        return Ability.builder() // Starting to build an ability (of the bot)
                .name("bye") // What comes after the command token / - "slash"
                .privacy(PUBLIC) // Privacy of the Command
                .locality(USER) // Who can use the command (in this case just users, no groups etc. )
                .input(0) // How many arguments command needs
                // Silently (without logging) sending message -> needs ChatID to know to whom to send the message
                // ChatID is given by msgContext (can be renamed)
                .action(msgContext -> {
                    // Converting message String into UTF_8 for correct layout in Telegram
                    silent.send(new String("TÜDELÜÜ".getBytes(), StandardCharsets.UTF_8), msgContext.chatId());
                    System.out.println(msgContext.chatId());
                })
                .build();
    }

    public Ability saySomething() {
        return Ability.builder() // Starting to build an ability (of the bot)
                .name("saysomething") // What comes after the command token / - "slash"
                .privacy(PUBLIC) // Privacy of the Command
                .locality(USER) // Who can use the command (in this case just users, no groups etc. )
                .input(0) // How many arguments command needs
                // Silently (without logging) sending message -> needs ChatID to know to whom to send the message
                // ChatID is given by msgContext (can be renamed)
                .action(msgContext -> silent.send("I'm giving up to you", msgContext.chatId()))
                .build();
    }

}
