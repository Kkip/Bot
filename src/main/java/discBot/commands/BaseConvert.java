    package discBot.commands;

    import org.javacord.api.event.message.MessageCreateEvent;
    import org.javacord.api.listener.message.MessageCreateListener;

    public class BaseConvert implements MessageCreateListener {
        // final base
        public static int baseTo10(char input) {
            if (input >= '0' && input <= '9') {
                return Integer.parseInt(input + "");
            }
            else {
                return (input - 'a') + 10;
            }
        }
        // initial base
        public static char invBaseTo10(int input) {
            if (input >= 0 && input <= 9) {
                String inputS = String.valueOf(input);
                return inputS.charAt(0);
            }
            else {
                return (char) ('a' + (input - 10));
            }
        }
        // converts to intermediary base 10
        public static int to10 (String input, int base) {
            int dec = 0;
            int len = input.length();
            for (int placeVal = 0, i = len - 1; i >= 0; placeVal++, i--) {
                dec += (baseTo10(input.charAt(i)) * (int) (Math.pow(base, placeVal)));
            }
            return dec;
        }
        // converts to final base
        public static String toBase(int input, int base) {
            String ans = "";
            int mod;
            while (input > 0) {
                mod = input % base;
                input /= base;
                ans = invBaseTo10(mod) + ans; // concatenation
            }
            return (ans);
        }
        public void onMessageCreate(MessageCreateEvent event) {
            String input = event.getMessageContent();
            String[] words = input.split("\\s+");
            // !baseConv
            if (words[0].equalsIgnoreCase("!baseConv") &&
                words[2].equalsIgnoreCase("from") &&
                words[4].equalsIgnoreCase("to")){
                    String num = words[1];
                    int baseIn = Integer.parseInt(words[3]);
                    int baseOut = Integer.parseInt(words[5]);
                    int dec = to10(num, baseIn);

                    String output = toBase(dec, baseOut);
                    event.getChannel().sendMessage(output);
            }
        }
    }