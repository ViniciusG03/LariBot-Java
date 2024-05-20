package br.com.vinicius.listener;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MyListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event)
    {
        System.out.println("Ready!");
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        Message message = event.getMessage();
        MessageChannel channel = message.getChannel();
        String messageContent = message.getContentRaw();
        if(messageContent.equals("!ping"))
        {
            channel.sendMessage("Pong!").queue();
        }
    }
}

