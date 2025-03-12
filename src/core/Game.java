package core;

import graphics.ui.GamePanel;
import core.managers.UIManager;

import javax.swing.*;
import java.awt.event.*;

public class Game implements Runnable {
    private boolean running = false;
    private Thread gameThread;

    private final int TARGET_FPS = 60;
    private final long OPTIMAL_TIME = 1_000_000_000 / TARGET_FPS;

    private Timer uiUpdateTimer;

    private JFrame window;
    private UIManager uiManager;
    
    

    public Game() {

        window = new JFrame("Space Game V3");
        uiManager = new UIManager(window);
        initUIUpdateTimer();
    }
    


    private void initUIUpdateTimer() {
        ActionListener uiUpdater = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uiManager.update();
            }
        };
        
        uiUpdateTimer = new Timer(100, uiUpdater);
        uiUpdateTimer.start();
    }
    
    public void start() {
        if (running) return;
        
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void stop() {
        if (!running) return;
        
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    
    private void render() {
        if (uiManager.getCurrentPanel() instanceof GamePanel) {
            // ((GamePanel)uiManager.getCurrentPanel()).render();
        }
    }

    private void update(double delta) {}

    @Override
    public void run() {
        long lastLoopTime = System.nanoTime();
        double delta = 0;
        
        while (running) {
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            delta = updateLength / ((double) OPTIMAL_TIME);
            
            update(delta);
            render();
            
            try {
                long sleepTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}