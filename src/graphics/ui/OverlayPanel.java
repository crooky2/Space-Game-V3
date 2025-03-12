package graphics.ui;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class OverlayPanel extends JPanel {
    
    public OverlayPanel() {
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Display score, health, etc.
        g.setColor(Color.WHITE);
        Font hudFont = new Font("Arial", Font.BOLD, 14);
        g.setFont(hudFont);
        
        g.drawString("SCORE: 0", 20, 30);
        g.drawString("HEALTH: 100%", 20, 50);
        g.drawString("LIVES: 3", 20, 70);
        
        // Add more HUD elements as needed
    }
}
