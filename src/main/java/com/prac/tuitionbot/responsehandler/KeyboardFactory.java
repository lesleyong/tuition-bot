package com.prac.tuitionbot.responsehandler;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class KeyboardFactory {

    private KeyboardFactory() {};

    public static ReplyKeyboard getPizzaToppingsKeyboard() {
        KeyboardRow row = new KeyboardRow();
        row.add("Margherita");
        row.add("Pepperoni");
        return new ReplyKeyboardMarkup(List.of(row));
    }

    public static ReplyKeyboard getMainActions(){
        KeyboardRow row = new KeyboardRow();
        row.add("My Points");
        row.add("Redemption");
        row.add("Refer a friend!");
        return new ReplyKeyboardMarkup(List.of(row));
    }

    public static ReplyKeyboard getYesOrNo() {
        KeyboardRow row = new KeyboardRow();
        row.add("Yes");
        row.add("No");
        return new ReplyKeyboardMarkup(List.of(row));
    }
}
