package discBot.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class SetAvatar implements MessageCreateListener{
        public void onMessageCreate(MessageCreateEvent event) {
        // !setAvatar
        if (event.getMessageContent().equalsIgnoreCase("!setAvatar")) {

            // checks if bot owner
            if (!event.getMessage().getAuthor().isBotOwner()) {
                event.getChannel().sendMessage("You are not the Owner");
                return;
            }

            event.getApi()
                    .updateAvatar(event.getMessage().getAuthor().getAvatar()) // avatar change
                    .thenRun(() -> event.getChannel().sendMessage("Updated")) // notify of change
                    .exceptionally(throwable -> {
                        // change failed
                        event.getChannel().sendMessage("Something went wrong: " + throwable.getMessage());
                        return null;
                    });
        }
    }
}