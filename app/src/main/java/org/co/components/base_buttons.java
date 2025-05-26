package org.co.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

import org.co.utils.base_conversion.base;

/**
 * custom button group made for base GUI 
 */
public class base_buttons extends JPanel {
    private final ButtonGroup group = new ButtonGroup();
    private final JRadioButton rbtn_binary, rbtn_ternary, rbtn_octal, rbtn_decimal;
    private  ActionListener listener;
    public base selected_base = base.binary;
    
    /**
     * initializes components and do basic setups
     * @param title title of the container box
     */
    public base_buttons(String title) {
        var border = BorderFactory.createTitledBorder(new LineBorder(Color.gray, 2), title); 
        border.setTitleColor(Color.blue);
        border.setTitleFont(new Font("dave_font", Font.BOLD, 12));
        setBorder(border);
        rbtn_binary = new JRadioButton("Binary");
        rbtn_ternary = new JRadioButton("Ternary");
        rbtn_octal = new JRadioButton("Octal");
        rbtn_decimal = new JRadioButton("Decimal");
        group.add(rbtn_binary);
        group.add(rbtn_ternary);
        group.add(rbtn_octal);
        group.add(rbtn_decimal);
        add(rbtn_binary);
        add(rbtn_ternary);
        add(rbtn_octal);
        add(rbtn_decimal);
        add_listener();
    }

    /**
     * defines behaviours of buttons
     */
    private void add_listener() {
        listener = (ActionEvent e) -> {
            if (e.getSource().getClass() != JRadioButton.class) return;
            var btn = (JRadioButton) e.getSource();
            if (btn == rbtn_binary) selected_base = base.binary;
            if (btn == rbtn_ternary) selected_base = base.ternary;
            if (btn == rbtn_octal) selected_base = base.octal;
            if (btn == rbtn_decimal) selected_base = base.decimal;
        };
        var btns = group.getElements();
        while (btns.hasMoreElements()) {
            var btn = btns.nextElement();
            btn.addActionListener(listener);
        }
    }
}
