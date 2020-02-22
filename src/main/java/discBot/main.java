package discBot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import java.util.Scanner;
import discBot.commands.setAvatar;
import discBot.commands.ping;
import discBot.commands.binArith;
import discBot.commands.baseConv;
import discBot.commands.help;

public class main {
        public static void main(String[] args) {
            // Insert bot's token here
            System.out.println("Input bot token: ");
            Scanner input = new Scanner(System.in);
            String token = input.nextLine();

            // blocking
            DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

            // opt
            api.setMessageCacheSize(10, 1800);

            // commands
            api.addMessageCreateListener(new setAvatar());
            api.addMessageCreateListener(new ping());
            api.addMessageCreateListener(new binArith());
            api.addMessageCreateListener(new baseConv());
            api.addMessageCreateListener(new help());

            // Print invite url
            System.out.println("Bot started!");
            System.out.println("Invite url created: " + api.createBotInvite());
        }
}