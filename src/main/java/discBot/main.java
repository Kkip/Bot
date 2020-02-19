package discBot;

import discBot.commands.addNumber;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import discBot.commands.setAvatar;
import discBot.commands.ping;
import java.util.Scanner;

public class main {
        public static void main(String[] args) {
            // Insert bot's token here
                System.out.println("Input bot token: ");
                Scanner input = new Scanner(System.in);
                String token = input.nextLine();

            // blocking
            DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

            // commands
            api.addMessageCreateListener(new setAvatar());
            api.addMessageCreateListener(new ping());
            api.addMessageCreateListener(new addNumber());

            // Print invite url
            System.out.println("Bot started!");
            System.out.println("Invite url created: " + api.createBotInvite());

        }
}

// note to deal with imports + consequences