package discBot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;


public class ping implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event){
    api.addMessageCreateListener(event -> {
        if (event.getMessageContent().equalsIgnoreCase("!userInfo")) {

            if (event.getMessage().getContent().equalsIgnoreCase("!ping")) {
            event.getChannel().sendMessage("Pong!");
            }
        });
    }
}


