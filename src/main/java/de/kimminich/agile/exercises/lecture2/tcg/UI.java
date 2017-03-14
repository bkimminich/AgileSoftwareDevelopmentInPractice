package de.kimminich.agile.exercises.lecture2.tcg;

import javax.swing.*;
import java.util.Arrays;

public class UI {

    public static Integer getInput(int... cards) {
        String sel;
        while ((sel = JOptionPane.showInputDialog("Choose a card to play: " + cards)) != null) {
            if (sel.matches("[1-8]")) {
                Integer c = Integer.valueOf(sel);
                if (Arrays.asList(cards).contains(c)) {
                    return c;
                } else {
                    JOptionPane.showMessageDialog(null, "You do not have this card!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        }
        return null;
    }

    public static void getMessage(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

}