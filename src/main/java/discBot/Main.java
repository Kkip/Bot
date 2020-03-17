package discBot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import java.util.Scanner;
import discBot.commands.SetAvatar;
import discBot.commands.Ping;
import discBot.commands.Arithmetic;
import discBot.commands.BaseConvert;
import discBot.commands.Help;

public class Main {
    public static void main(String[] args) {
        // Insert bot's token here
        System.out.println("Input bot token: ");
        Scanner in = new Scanner(System.in);
        try {}
        finally {
            in.close();
        } 
        String token = in.nextLine();

        // blocking
        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // opt
        api.setMessageCacheSize(10, 1800);

        // basic commands
        api.addMessageCreateListener(new SetAvatar());
        api.addMessageCreateListener(new Ping());
        api.addMessageCreateListener(new Arithmetic());
        api.addMessageCreateListener(new BaseConvert());
        api.addMessageCreateListener(new Help());

        // moderation

        // Print invite url
        System.out.println("Bot started!");
        System.out.println("Invite url created: " + api.createBotInvite());
    }
}