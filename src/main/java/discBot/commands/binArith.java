package discBot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class binArith implements MessageCreateListener {
    public void onMessageCreate(MessageCreateEvent event) {
                String input = event.getMessageContent();
        String[] words = input.split("\\s+");
        double output; // declares output variable

        // !compute2 command
        if (words[0].equalsIgnoreCase("!compute2")) {
            // int check
            try {
                Double.parseDouble(words[2]);
                Double.parseDouble(words[3]);
            }
            // error check
            catch (NumberFormatException e) {
                event.getChannel().sendMessage("use !compute2 help to see commands.");
            }
            // output
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
                output = Double.parseDouble(words[2]) / Double.parseDouble(words[3]);
                event.getChannel().sendMessage(Double.toString(output));
            }

        }
    }
}