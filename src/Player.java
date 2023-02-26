import java.awt.*;

public class Player {
    int bodyParts = 2;
    int x[] = new int[(int)Const_size.SCREEN_WIDTH/Const_size.UNIT_SIZE];
    int y[] = new int[(int)Const_size.SCREEN_HEIGHT/Const_size.UNIT_SIZE];
    Direction direction = Direction.RIGHT;
    boolean alive = true;

    void draw(Graphics g){
        g.setColor(Color.GREEN);
        int i;
        for(i=bodyParts;i>0;i--){
            g.fillRect(x[i],y[i],Const_size.UNIT_SIZE,Const_size.UNIT_SIZE);
        }
        g.setColor(new Color(45,180,0));
        g.fillRect(x[i],y[i],Const_size.UNIT_SIZE,Const_size.UNIT_SIZE);
    }

    void move(){

    }

}
