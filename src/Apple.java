import java.awt.*;
import java.io.Serializable;
import java.util.Random;

public class Apple implements Serializable {
    int x_position;
    int y_position;
    boolean exist = true;
    void set_position(){
        Random random = new Random();
        x_position= random.nextInt((int)(Const_size.SCREEN_WIDTH/Const_size.UNIT_SIZE))*Const_size.UNIT_SIZE;
        y_position=random.nextInt((int)(Const_size.SCREEN_HEIGHT/Const_size.UNIT_SIZE))*Const_size.UNIT_SIZE;
    }
    void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x_position,y_position,
                Const_size.UNIT_SIZE, Const_size.UNIT_SIZE);
    }

}
