package discBot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class baseConv implements MessageCreateListener {
    public static int baseTo10(char input) {
        if (input >= '0' && input <= '9') {
            return Integer.parseInt(input + "");
        }
        else {
            return (int) (input - 'a') + 10;
        }
    }
    public static char invBaseTo10(int input) {
        if (input >= 0 && input <= 9) {
            String inputS = String.valueOf(input);
            return inputS.charAt(0);
        }
        else {
            return (char) ('a' + (input - 10));
        }
    }
    public static int to10 (String input, int base) {
        int dec = 0;
        for (int placeVal = 0, i = input.length() - 1; i >= 0; placeVal++, i--) {
            dec = dec + baseTo10(input.charAt(i)) * (int) (Math.pow(base, placeVal));
        }
        return dec;
    }
    public static String toBase(int input, int base) {
        String ans = "";
        while (input > 0) {
            int mod = input % base;
            input = input / base;
            ans = invBaseTo10(mod) + ans;
        }
        return ans;
    }
    public void onMessageCreate(MessageCreateEvent event) {
        String input = event.getMessageContent();
        String[] words = input.split("\\s+");

        if (words[0].equalsIgnoreCase("!baseConv")){
            //try{} // catch for word mismatch and word equals
            //catch{}
            int baseIn = Integer.parseInt(words[1]);
            int baseOut = Integer.parseInt(words[2]);
            String num = words[3];
            int dec = to10(num, baseIn);
            String output = toBase(dec, baseOut);
            event.getChannel().sendMessage(output);
        }
    }
}