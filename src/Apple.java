import java.awt.*;
import java.util.Random;

public class Apple {
    int x_position=1;
    int y_position=1;
    boolean exist = true;
    void set_position(Const_size constant){
        x_position=50;
        y_position=50;
    }
    void draw(Graphics g,Const_size constant_size){
        g.setColor(Color.RED);
        g.fillOval(3*constant_size.UNIT_SIZE,10*constant_size.UNIT_SIZE,
                constant_size.UNIT_SIZE, constant_size.UNIT_SIZE);
    }

}
