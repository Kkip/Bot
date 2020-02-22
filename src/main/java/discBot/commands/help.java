package discBot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class help implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event) {
        String input = event.getMessageContent();
        String[] words = input.split("\\s+");
        if (words[0].equalsIgnoreCase("!help")) {
            if (words[1].equalsIgnoreCase("ping")) {
                event.getChannel().sendMessage("Why are you trying to figure out how to use !ping?");
                // note to link strings of command calls to file for easier maintenance
            }
            else if (words[1].equalsIgnoreCase("binArith")) {
                event.getChannel().sendMessage("help text");
            }
        }
    }
}
