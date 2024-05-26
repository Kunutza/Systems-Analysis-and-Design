import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlaceholderTextField extends JTextField {
    private String placeholder;

    public PlaceholderTextField(String placeholder, Integer columns) {
    	super.setColumns(columns);
        this.placeholder = placeholder;
        setForeground(Color.GRAY);
        setText(placeholder);
        
        // Add focus listener to handle placeholder behavior
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeholder)) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(placeholder);
                    setForeground(Color.GRAY);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getText().isEmpty() && !hasFocus()) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(getForeground());
            g2d.drawString(placeholder, getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
            g2d.dispose();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(super.getPreferredSize().width, 
                              super.getPreferredSize().height + getInsets().top);
    }
    
    public String getPlaceholder() {
    	return this.placeholder;
    }
}
