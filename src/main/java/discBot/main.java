package discBot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class main {
    public static void main(String[] args) {
        // Insert bot's token here
        String token = "Njc4MTEyMTQxMTU2Mjg2NDk0.XkskLQ.S2kt8DW2ZP0IjwtR6jRka1PXUzE";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // Replies with "Pong!" if someone writes "!ping"
        api.addMessageCreateListener(event -> {
            if (event.getMessage().getContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
        });

    }
}

// note to deal with imports + consequences