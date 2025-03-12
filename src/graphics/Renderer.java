package graphics;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import core.entities.Entity;

public class Renderer {
    private static Renderer instance;
    
    private Graphics2D graphics;
    
    private Renderer() {}
    
    public static Renderer getInstance() {
        if (instance == null) {
            instance = new Renderer();
        }
        return instance;
    }
    
    public void setGraphics(Graphics2D g) {
        this.graphics = g;
    }
    
    public void clear(Color color) {
        if (graphics == null) return;
        
        Color oldColor = graphics.getColor();
        graphics.setColor(color);
        graphics.fillRect(0, 0, 800, 600);
        graphics.setColor(oldColor);
    }
    
    public void drawEntity(Entity entity) {
        if (graphics == null || entity == null) return;
    

    }
    
    public void drawText(String text, int x, int y, Font font, Color color) {
        if (graphics == null) return;
        
        Font oldFont = graphics.getFont();
        Color oldColor = graphics.getColor();
        
        graphics.setFont(font);
        graphics.setColor(color);
        graphics.drawString(text, x, y);
        
        graphics.setFont(oldFont);
        graphics.setColor(oldColor);
    }
}
