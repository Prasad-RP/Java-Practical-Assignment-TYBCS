
/*
SET C 
a) Write a program that simulates a traffic light. The program lets the user select one of
three lights: red, yellow, or green with radio buttons. On selecting a button, an
appropriate message with “stop” or “ready” or “go”should appear above the buttons in
a selected color. Initially there is no message shown.
*/
import java.awt.Color;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class SETC1 extends JFrame implements ItemListener {

    JPanel msgPanel, lightPanel;
    JLabel message;
    ButtonGroup btn_group;
    JRadioButton red, yellow, green;

    SETC1() {

        setBackground(Color.BLACK);
        setLayout(new GridLayout(2, 1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        msgPanel = new JPanel();
        lightPanel = new JPanel();
        message = new JLabel("Select Light");
        btn_group = new ButtonGroup();
        red = new JRadioButton("Red");
        yellow = new JRadioButton("Yellow");
        green = new JRadioButton("Green");
        red.setForeground(Color.RED);
        yellow.setForeground(Color.YELLOW);
        green.setForeground(Color.GREEN);

        btn_group.add(red);
        btn_group.add(yellow);
        btn_group.add(green);

        red.addItemListener(this);
        yellow.addItemListener(this);
        green.addItemListener(this);

        msgPanel.add(message);
        lightPanel.add(red);
        lightPanel.add(yellow);
        lightPanel.add(green);

        add(msgPanel);
        add(lightPanel);

        setSize(500, 300);
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        JRadioButton selected = (JRadioButton) ie.getSource();
        String textOnButton = selected.getText();
        if (textOnButton.equals("Red")) {
            message.setForeground(Color.RED);
            message.setText("STOP");
        } else if (textOnButton.equals("Yellow")) {
            message.setForeground(Color.YELLOW);
            message.setText("READY");
        } else {
            message.setForeground(Color.GREEN);
            message.setText("GO");
        }
    }

    public static void main(String[] args) {
        new SETC1();
    }

}