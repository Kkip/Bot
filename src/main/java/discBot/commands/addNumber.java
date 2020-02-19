package discBot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class addNumber implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event) {
        boolean containsInt = true;

        String input = event.getMessageContent();

        String[] words = input.split("\\s+");

        if (words[0].equalsIgnoreCase("!addNumber")) {
            // int check
            try {
                Integer.parseInt(words[1]);
                Integer.parseInt(words[2]);
            }
            // error check
            catch (NumberFormatException e) {
                containsInt = false;
                event.getChannel().sendMessage("Error: input does not contain integers.");
            }
            //output
            if (containsInt) {
                int output = Integer.parseInt(words[1]) + Integer.parseInt(words[2]);
                event.getChannel().sendMessage(Integer.toString(output));
            }
        }
    }
}