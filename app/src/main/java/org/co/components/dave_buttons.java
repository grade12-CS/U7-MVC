package org.co.components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class dave_buttons extends JPanel {
    public static enum base {
        binary, teriary, octal, decimal;
    }

    private final ButtonGroup group = new ButtonGroup();
    private final JRadioButton rbtn_binary, rbtn_teriary, rbtn_octal, rbtn_decimal;
    private  ActionListener listener;
    public base selected_base = base.binary;

    public dave_buttons() {
        setBorder(new LineBorder(Color.gray, 10));
        rbtn_binary = new JRadioButton("Binary");
        rbtn_teriary = new JRadioButton("Teriary");
        rbtn_octal = new JRadioButton("Octal");
        rbtn_decimal = new JRadioButton("Decimal");
        group.add(rbtn_binary);
        group.add(rbtn_teriary);
        group.add(rbtn_octal);
        group.add(rbtn_decimal);
        add(rbtn_binary);
        add(rbtn_teriary);
        add(rbtn_octal);
        add(rbtn_decimal);
        add_listener();
    }

    private void add_listener() {
        listener = (ActionEvent e) -> {
            if (e.getSource().getClass() != JRadioButton.class) return;
            var btn = (JRadioButton) e.getSource();
            if (btn == rbtn_binary) selected_base = base.binary;
            if (btn == rbtn_teriary) selected_base = base.teriary;
            if (btn == rbtn_octal) selected_base = base.octal;
            if (btn == rbtn_decimal) selected_base = base.decimal;
            System.out.println("selected " + btn.getText());
        };
        var btns = group.getElements();
        while (btns.hasMoreElements()) {
            var btn = btns.nextElement();
            btn.addActionListener(listener);
        }
    }
}
