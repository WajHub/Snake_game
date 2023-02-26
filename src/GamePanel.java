import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    Apple apple = new Apple();
    Player player = new Player();
    int delay = 175;
    Timer timer = new Timer(delay,this::actionPerformed);
    GamePanel(){
        this.setFocusable(true);
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension (Const_size.SCREEN_WIDTH,Const_size.SCREEN_HEIGHT));
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame(){
        apple.set_position(player);
    }

    //By now you know that the paintComponent method is where all of your painting
    // code should be placed. It is true that this method will be invoked when it is time to paint
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        for(int i=1;i*Const_size.UNIT_SIZE<Const_size.SCREEN_WIDTH;i++){
            g.drawLine(i*Const_size.UNIT_SIZE,0,i*Const_size.UNIT_SIZE,Const_size.SCREEN_HEIGHT);
        }
        for(int i=1;i*Const_size.UNIT_SIZE<Const_size.SCREEN_HEIGHT;i++){
            g.drawLine(0,i*Const_size.UNIT_SIZE,Const_size.SCREEN_WIDTH,i*Const_size.UNIT_SIZE);
        }
        apple.draw(g);
        player.draw(g);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
