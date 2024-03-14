package com.prac.tuitionbot.responsehandler;

import com.prac.tuitionbot.MainActions;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;

import java.util.List;

import static com.prac.tuitionbot.util.Constants.*;

public class ResponseHandler {

    private final SilentSender sender;

    public ResponseHandler(SilentSender sender) {
        this.sender = sender;
    }

    public void handleNewMemberUpdates(long chatId, Message message) {
        if(!message.getNewChatMembers().isEmpty()) {
            List<User> newUsers = message.getNewChatMembers();
            newUsers.stream().forEach(user -> sendMessage(chatId, String.format(WELCOME_TEXT, user.getUserName())));
        }
    }

    public void handleChatUpdates(long chatId, Message message) {
        if (message.getText().equalsIgnoreCase(START)) {
            startChat(chatId);
        }
        else if (message.getText().equalsIgnoreCase(STOP)) {
            stopChat(chatId);
        }
        else if (message.getText().equalsIgnoreCase(MainActions.MY_POINTS.getName())) {

        }
        else if (message.getText().equalsIgnoreCase(MainActions.REDEMPTION.getName())) {

        }
        else if (message.getText().equalsIgnoreCase(MainActions.REFER.getName())) {

        }
        else {
            unexpectedMessage(chatId);
        }
    }

    public void sendMessage(long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sender.execute(sendMessage);
    }

    private void startChat(long chatId) {
        promptWithKeyboardForState(chatId, START_TEXT, KeyboardFactory.getMainActions());
    }

    private void stopChat(long chatId) {
        promptWithKeyboardForState(chatId, STOP_CHAT, new ReplyKeyboardRemove(true));
    }

    private void promptWithKeyboardForState(long chatId, String text, ReplyKeyboard replyKeyboard) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(replyKeyboard);
        sender.execute(sendMessage);
    }

    private void unexpectedMessage(long chatId) {
        sendMessage(chatId, "I did not expect that.");
    }

    public boolean userIsActive(Long chatId) {
        return false;
    }
}
