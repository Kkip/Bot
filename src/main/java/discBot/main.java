package discBot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import discBot.commands.setAvatar;
import discBot.commands.ping

public class main {
        public static void main(String[] args) {
            // Insert bot's token here
            String token = "Njc4MTEyMTQxMTU2Mjg2NDk0.XktYNg.cD7outNHQmuCjng07_XIyS2ufrM";

            // blocking
            DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

            // commands
            api.addMessageCreateListener(new setAvatar());
            api.addMessageCreateListener(new ping());

            // Print invite url
            System.out.println("Invite url: " + api.createBotInvite());

        }
}

// note to deal with imports + consequences