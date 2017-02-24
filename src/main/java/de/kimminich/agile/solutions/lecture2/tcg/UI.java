package de.kimminich.agile.solutions.lecture2.tcg;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class UI {

    public static Integer selectCardFrom(List<Integer> cards) {
        String input;
        while ((input = JOptionPane.showInputDialog("Choose a card to play: " + cards)) != null) {
            if (input.matches("[1-8]")) {
                Integer card = Integer.valueOf(input);
                if (cards.contains(card)) {
                    return card;
                } else {
                    JOptionPane.showMessageDialog(null, "You do not have this card!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        }
        return null;
    }

    public static void showMessage(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

}