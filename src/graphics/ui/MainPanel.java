package graphics.ui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

import graphics.ui.components.SlantedButton;

public class MainPanel extends JPanel {
    
    public MainPanel() {        
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        
        setupComponents();
    }
    
    private void setupComponents() {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(50, 40, 50, 0));
        
        JLabel titleLabel = new JLabel("space");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        
        add(titlePanel, BorderLayout.WEST);


        
        JPanel eastContainer = new JPanel(new GridBagLayout());
        eastContainer.setBackground(Color.BLACK);  

        JPanel updatePanel = new JPanel();
        updatePanel.setBackground(new Color(10, 10, 15));
        updatePanel.setLayout(new BorderLayout());
        updatePanel.setPreferredSize(new Dimension(300, 400));
        
        updatePanel.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(30, 30, 50), 1),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        JLabel updateLabel = new JLabel("<html><div style='color: white; font-family: Arial; text-align: left'>" +
                                       "<span style='font-size: 16px'>Version 0</span><br>" +
                                       "</div></html>");
        
        updatePanel.add(updateLabel, BorderLayout.NORTH);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 0, 40);
        eastContainer.add(updatePanel, gbc);
        
        add(eastContainer, BorderLayout.EAST);



        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 40, 60, 0));
        
        SlantedButton playButton = new SlantedButton("PLAY", null, 200, 45);
        
        SlantedButton controlButton = new SlantedButton("CONTROLS", null, 260, 45);
        
        SlantedButton exitButton = new SlantedButton("EXIT", e -> System.exit(0), 320, 45);
        
        buttonPanel.add(playButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        buttonPanel.add(controlButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        buttonPanel.add(exitButton);
        
        JPanel alignmentPanel = new JPanel(new BorderLayout());
        alignmentPanel.setBackground(Color.BLACK);
        alignmentPanel.add(buttonPanel, BorderLayout.WEST);
        
        add(alignmentPanel, BorderLayout.SOUTH);
    }
}
