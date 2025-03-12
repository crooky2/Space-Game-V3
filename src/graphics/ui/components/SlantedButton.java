package graphics.ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SlantedButton extends JButton {
    private final int width;
    private final int slantSize;
    private final int textPadding = 15;

    public SlantedButton(String text, ActionListener action, int width, int slantSize) {
        super(text);
        this.width = width;
        this.slantSize = slantSize;

        setFont(new Font("Arial", Font.BOLD, 18));
        setForeground(Color.WHITE);
        setBackground(new Color(50, 50, 50));
        setFocusPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createEmptyBorder());
        setPreferredSize(new Dimension(width, 50));
        setMaximumSize(new Dimension(width, 50));

        if (action != null) {
            addActionListener(action);
        }

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(new Color(80, 80, 80));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(new Color(50, 50, 50));
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int[] xPoints = {0, width - slantSize, width, width, 0}; 
        int[] yPoints = {0, 0, getHeight(), getHeight(), getHeight()};

        g2.setColor(getBackground());
        g2.fillPolygon(xPoints, yPoints, xPoints.length);

        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(
            getText(), 
            textPadding, 
            (getHeight() + fm.getAscent()) / 2 - 2
        );

        g2.dispose();
    }
}
