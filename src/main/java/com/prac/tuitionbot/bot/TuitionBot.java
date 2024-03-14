package com.prac.tuitionbot.bot;

import com.prac.tuitionbot.responsehandler.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.prac.tuitionbot.util.Constants.CHANNEL_ID;
import static org.telegram.abilitybots.api.util.AbilityUtils.getChatId;

@Component
public class TuitionBot extends AbilityBot {

    private final ResponseHandler responseHandler;

    @Autowired
    public TuitionBot(Environment env) {
        super(env.getProperty("botToken"), "TuitionButler_Bot");
        responseHandler = new ResponseHandler(silent);
    }

    @Override
    public long creatorId() {
        return 0;
    }

    @Override
    public void onRegister() {
        responseHandler.sendMessage(CHANNEL_ID, "hello");
    }

    @Override
    public void onUpdateReceived(Update update) {
        responseHandler.handleNewMemberUpdates(getChatId(update), update.getChannelPost());
        responseHandler.handleChatUpdates(getChatId(update), update.getMessage());
    }
}
