package org.co.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class dave_textfield extends JPanel {
    private final JLabel label;
    private final JTextField text;

    public dave_textfield(String label_text) {
        setBackground(Color.yellow);
        setPreferredSize(new Dimension(400, 100));
        setLayout(new GridBagLayout());
        text = new JTextField();
        text.setColumns(12);
        label = new JLabel(label_text);
        label.setHorizontalAlignment(JLabel.TRAILING);
        label.setLabelFor(text);
        label.setForeground(Color.blue);
        label.setFont(new Font("dave_font", Font.BOLD, 12));
        //TODO: align components to the left on the panel. this is driving me nuts
        var c = new GridBagConstraints();
        c.gridx = 0; c.gridy = 0;
        add(label, c);
        c.gridx = 1;
        add(text, c);
    }
}
