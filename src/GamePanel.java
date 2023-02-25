import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    Const_size constant_size = new Const_size();
    Apple apple = new Apple();
    Random random = new Random();
    GamePanel(){
        this.setFocusable(true);
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(constant_size.SCREEN_WIDTH,constant_size.SCREEN_HEIGHT));
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame(){
    }

    //By now you know that the paintComponent method is where all of your painting
    // code should be placed. It is true that this method will be invoked when it is time to paint
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        for(int i=1;i*constant_size.UNIT_SIZE<constant_size.SCREEN_WIDTH;i++){
            g.drawLine(i*constant_size.UNIT_SIZE,0,i*constant_size.UNIT_SIZE,constant_size.SCREEN_HEIGHT);
        }
        for(int i=1;i*constant_size.UNIT_SIZE<constant_size.SCREEN_HEIGHT;i++){
            g.drawLine(0,i*constant_size.UNIT_SIZE,constant_size.SCREEN_WIDTH,i*constant_size.UNIT_SIZE);
        }
        apple.draw(g,constant_size);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
