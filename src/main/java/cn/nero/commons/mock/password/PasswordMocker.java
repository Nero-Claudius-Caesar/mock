package cn.nero.commons.mock.password;

import lombok.Data;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Objects;
import java.util.Random;

/**
 * @author Nero Claudius
 * @version 1.0.0
 * @since 2024/2/8
 * password mocker
 */
public class PasswordMocker {

    private static final char[] DEFAULT_SYMBOL = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_-+=.!@".toCharArray();

    private static final int DEFAULT_LEN = 16;

    private static final int SYMBOL_SIZE = DEFAULT_SYMBOL.length;

    private static void set2SystemClipboard (String data) {
        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(data);
        systemClipboard.setContents(stringSelection, null);
    }

    public static String mock (Integer len) {

        len = Objects.requireNonNullElse(len, DEFAULT_LEN);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(DEFAULT_SYMBOL[new Random().nextInt(SYMBOL_SIZE - 1)]);
        }

        System.out.println(sb);

        set2SystemClipboard(sb.toString());

        return sb.toString();
    }

    @Data
    public static class Option {

        private boolean symbolMixed = true;

        private boolean autoCopyToClipboard = false;

        private char[] customSymbol;

    }

    public static void main(String[] args) {
        PasswordMocker.mock(32);
    }


}
