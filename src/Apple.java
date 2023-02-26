import java.awt.*;
import java.util.Random;

public class Apple {
    int x_position;
    int y_position;
    boolean exist = true;
    void set_position(Player player){
        Random random = new Random();
        x_position= random.nextInt((int)(Const_size.SCREEN_WIDTH/Const_size.UNIT_SIZE)+1);
        y_position=random.nextInt((int)(Const_size.SCREEN_HEIGHT/Const_size.UNIT_SIZE)+1);;
    }
    void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x_position*Const_size.UNIT_SIZE,y_position*Const_size.UNIT_SIZE,
                Const_size.UNIT_SIZE, Const_size.UNIT_SIZE);
    }

}
