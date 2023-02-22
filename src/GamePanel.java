import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    GamePanel(){
        Random random = new Random();
        this.setFocusable(true);
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(500,500));
        this.addKeyListener(new MyKeyAdapter());
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
