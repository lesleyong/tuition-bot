package com.prac.tuitionbot.responsehandler;

import com.prac.tuitionbot.MainActions;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class KeyboardFactory {

    private KeyboardFactory() {};

    public static ReplyKeyboard getMainActions(){
        KeyboardRow row = new KeyboardRow();
        row.add(MainActions.MY_POINTS.getName());
        row.add(MainActions.REDEMPTION.getName());
        row.add(MainActions.REFER.getName());
        return new ReplyKeyboardMarkup(List.of(row));
    }
}
