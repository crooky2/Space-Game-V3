import core.Game;

public class App {
    public static void main(String[] args) {
        // System.setProperty("sun.java2d.opengl", "true");
        System.setProperty("sun.java2d.d3d", "true");
        System.setProperty("sun.java2d.ddforcevram", "true");
        
        
        Game game = new Game();
        game.start();
    }
}