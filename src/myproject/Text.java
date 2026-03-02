package myproject;

import javax.swing.*;
import java.awt.*;

public class Text {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 500);
        frame.setVisible(true);   // 先顯示

        Insets insets = frame.getInsets();

        System.out.println("上: " + insets.top);
        System.out.println("下: " + insets.bottom);
        System.out.println("左: " + insets.left);
        System.out.println("右: " + insets.right);
    }
}
