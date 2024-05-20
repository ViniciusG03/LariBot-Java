package br.com.vinicius.manager;

import br.com.vinicius.listener.MyListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class BotManager {

    private JDABuilder jdaBuilder;

    public BotManager() {
        String dir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + dir);

        Dotenv dotenv = Dotenv.configure()
                .directory(dir)
                .load();

        String token = dotenv.get("DISCORD_TOKEN");

        if (token == null) {
            throw new IllegalStateException("DISCORD_TOKEN not found in .env file");
        }

        jdaBuilder = JDABuilder.createDefault(token);
        jdaBuilder.addEventListeners(new MyListener());
        jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
    }

    public void startBot() throws LoginException {
        jdaBuilder.build();
    }
}
