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
        for(int i = bodyParts;i>0;i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
        }
        switch (direction){
            case RIGHT:
                x[0]+=Const_size.UNIT_SIZE;
                break;
            case LEFT:
                x[0]-=Const_size.UNIT_SIZE;
                break;
            case UP:
                y[0]-=Const_size.UNIT_SIZE;
                break;
            case DOWN:
                y[0]+=Const_size.UNIT_SIZE;
                break;
        }
    }

}
