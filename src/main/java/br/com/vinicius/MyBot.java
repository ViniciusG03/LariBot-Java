package br.com.vinicius;

import br.com.vinicius.manager.BotManager;

import javax.security.auth.login.LoginException;

public class MyBot {
    public static void main(String[] args) {

        try {
            new BotManager().startBot();
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }
}