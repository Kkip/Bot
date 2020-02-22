package discBot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class ping implements MessageCreateListener {
        public void onMessageCreate(MessageCreateEvent event) {
            String input = event.getMessageContent();
            String[] words = input.split("\\s+");
            // !ping
            if (words[0].equalsIgnoreCase("!ping")) {
                if (words[1].equalsIgnoreCase("kelvin")) {
                    event.getChannel().sendMessage("@LKelvin#1702");
                }
                else {
                    event.getChannel().sendMessage("pong!");
                }
            }
        }
}

// use this for testing stuff if necessary