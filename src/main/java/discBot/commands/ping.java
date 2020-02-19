package discBot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class ping implements MessageCreateListener {
        public void onMessageCreate(MessageCreateEvent event){
            if (event.getMessageContent().toLowerCase().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
                }
            });
    }
}