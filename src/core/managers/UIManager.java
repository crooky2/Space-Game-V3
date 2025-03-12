package core.managers;

import graphics.ui.*;
// import graphics.ui.menus.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.SwingUtilities;

public class UIManager {
    private JFrame window;
    private JPanel contentPane;
    private CardLayout cardLayout;
    
    private GamePanel gamePanel;
    private MainPanel mainPanel;
    
    public static final String GAME_PANEL = "GAME";
    public static final String MAIN_PANEL = "MAIN";
    
    private GraphicsDevice device;
    
    // private DeathScreen deathScreen;
    // private PauseMenu pauseMenu;
    // private SpecialMenu specialMenu;
    // private UpgradeMenu upgradeMenu;
    
    public UIManager(JFrame window) {
        this.window = window;
        this.device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        
        initComponents();
        
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        
        showPanel(MAIN_PANEL);
        

        if (device.isFullScreenSupported()) {
            SwingUtilities.invokeLater(() -> {
                try {
                    window.dispose();
                    window.setUndecorated(true);
                    window.setResizable(false);
                    device.setFullScreenWindow(window);
                    
                    window.revalidate();
                    contentPane.revalidate();
                    mainPanel.revalidate();
                    mainPanel.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                    window.dispose();
                    window.setUndecorated(false);
                    window.setSize(800, 600);
                    window.setLocationRelativeTo(null);
                    window.setVisible(true);
                }
            });
        }
    }
    
    private void initComponents() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Space Game V3");
        
        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        window.setContentPane(contentPane);
        
        gamePanel = new GamePanel();
        mainPanel = new MainPanel();
        
        contentPane.add(gamePanel, GAME_PANEL);
        contentPane.add(mainPanel, MAIN_PANEL);
    }
    
    public void showPanel(String panelName) {
        System.out.println("Showing panel: " + panelName);
        cardLayout.show(contentPane, panelName);
        
        if (GAME_PANEL.equals(panelName)) {
            gamePanel.requestFocus();
        } else if (MAIN_PANEL.equals(panelName)) {
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }
    
    public Component getCurrentPanel() {
        if (contentPane.getComponentCount() > 0) {
            for (Component comp : contentPane.getComponents()) {
                if (comp.isVisible()) {
                    return comp;
                }
            }
        }
        return gamePanel;
    }
    
    public void update() {
        Component currentPanel = getCurrentPanel();
        currentPanel.repaint();
    }
}
