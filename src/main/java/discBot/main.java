package discBot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class main {
    public static void main(String[] args) {
        // Insert bot's token here
        String token = "Njc4MTEyMTQxMTU2Mjg2NDk0.XktYNg.cD7outNHQmuCjng07_XIyS2ufrM";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
  
        // Replies with "Pong!" if someone writes "!ping"
        api.addMessageCreateListener(event -> {
            if (event.getMessage().getContent().equalsIgnoreCase("!ping")) {
                event.getChannel().sendMessage("Pong!");
            }
        });

        // Print invite url
        System.out.println("Invite url: " + api.createBotInvite());

    }
}

// note to deal with imports + consequences