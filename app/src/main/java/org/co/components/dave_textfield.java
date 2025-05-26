package org.co.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 * a custom textfield integrated with a label
 */
public class dave_textfield extends JPanel {
    private final JLabel label;
    private final JTextField text;
    private int value = 0;

    /**
     * initializes components and do basic setups
     * @param label_text label name of the textfield
     */
    public dave_textfield(String label_text) {
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
        add_doc_listener();
    }

    /**
     * resets textfield and value
     */
    public void reset() {
        value = 0;
        text.setText("");
    }

    /**
     * retrieves value from textfield
     * @return value of textfield
     */
    public double get_value() {
        return value;
    }

    /**
     * changes value of textfield
     * @param value desired value to change into
     */
    public void set_value(int value) {
        this.value = value;
    }

    /**
     * changes text of textfield
     * @param txt text to update
     */
    public void set_text(String txt) {
        text.setText(txt);
    }

    /**
     * retreives text of textfield
     * @return text value of textfield
     */
    public String get_text() {
        return text.getText();
    } 

    /**
     * make value updated with textfield text only if the text is made of digits
     */
    private void add_doc_listener() {
        text.getDocument().addDocumentListener((SimpleDocumentListener) (var e) -> {
            try {
                String txt = e.getDocument().getText(0, e.getDocument().getLength());
                if (txt.isEmpty()) return;
                for (Character c : txt.toCharArray()) {
                    if (!Character.isDigit(c)) {
                        System.err.println("only digits are allowed");
                    }
                }    
                value = Integer.parseInt(txt); 
            } catch (BadLocationException e1) {
                System.err.println("Wrong index");
            }
        });
    }

     /**
     * constructs a simple interface for a document listner that allows recieving all document event in one method
     * it is to remove the cubersome that original document listener has
     */
    @FunctionalInterface
    public interface SimpleDocumentListener extends DocumentListener {
        void update(DocumentEvent e);

        @Override
        default void insertUpdate(DocumentEvent e) {
            update(e);
        }
        @Override
        default void removeUpdate(DocumentEvent e) {
            update(e);
        }
        @Override
        default void changedUpdate(DocumentEvent e) {
            update(e);
        }
    }
}
