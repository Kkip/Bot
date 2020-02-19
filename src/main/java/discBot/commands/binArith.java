package discBot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class binArith implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event) {
        /* boolean containsLF = true; see comments, commented out because i think this isnt needed since the try catch
        should just end this; delete it confirmed*/
        String input = event.getMessageContent();
        String[] words = input.split("\\s+");

        // !compute2 command
        if (words[0].equalsIgnoreCase("!compute2")) {
            // int check
            try {
                Double.parseDouble(words[2]);
                Double.parseDouble(words[3]);
            }
            // error check
            catch (NumberFormatException e) {
                // containsLF = false;
                event.getChannel().sendMessage("Error: input does not contain integers.");
            }
            // output
            double output; // move this to a better spot
            // if (containsLF && words[1].equalsIgnoreCase("add_2")) {
            if (words[1].equalsIgnoreCase("add")) {
                output = Double.parseDouble(words[2]) + Double.parseDouble(words[3]);
                event.getChannel().sendMessage(Double.toString(output));
            }
            else if ((words[1].equalsIgnoreCase("subtract2"))) {
                output = Double.parseDouble(words[2]) - Double.parseDouble(words[3]);
                event.getChannel().sendMessage(Double.toString(output));
            }
            else if ((words[1].equalsIgnoreCase("multiply2"))) {
                output = Double.parseDouble(words[2]) * Double.parseDouble(words[3]);
                event.getChannel().sendMessage(Double.toString(output));
            }
            else if ((words[1].equalsIgnoreCase("divide2"))) {
                output = Double.parseDouble(words[2]) ^ Double.parseDouble(words[3]);
                event.getChannel().sendMessage(Double.toString(output));
            }

        }
    }
}