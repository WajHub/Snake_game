import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    GameFrame(){
        this.add(new GamePanel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(300,50);
        this.setResizable(false);
        this.pack();
    }
}
