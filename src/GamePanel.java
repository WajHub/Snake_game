import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

public class GamePanel extends JPanel implements ActionListener {
    Apple apple = new Apple();
    Player player = new Player();
    int delay = 100;
    Timer timer = new Timer(delay, this::actionPerformed);
    
    boolean pause = false;

    GamePanel() {
        this.setFocusable(true);
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(Const_size.SCREEN_WIDTH, Const_size.SCREEN_HEIGHT+100));
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        apple.set_position();
        timer.start();
    }

    //By now you know that the paintComponent method is where all of your painting
    // code should be placed. It is true that this method will be invoked when it is time to paint
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.drawLine(0, Const_size.SCREEN_HEIGHT , Const_size.SCREEN_WIDTH,  Const_size.SCREEN_HEIGHT);
        apple.draw(g);
        player.draw(g);
        draw_score(g);
        if(!player.alive) draw_game_over(g);
        if(pause) draw_pause(g);
        repaint();
    }
    public void draw_score(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free",Font.BOLD,75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score: "+player.score,(Const_size.SCREEN_WIDTH-metrics.stringWidth("Score:  "))/2,Const_size.SCREEN_HEIGHT+75);
    }
    public void draw_game_over(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free",Font.BOLD,100));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over",(Const_size.SCREEN_WIDTH-metrics.stringWidth("Game Over"))/2,Const_size.SCREEN_HEIGHT/2);
    }
    public void draw_pause(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free",Font.BOLD,100));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Pause",(Const_size.SCREEN_WIDTH-metrics.stringWidth("Pause"))/2,Const_size.SCREEN_HEIGHT/2);
    }
    public void save_game(){
        pause=true;
        String save_player = "player_state.txt";
        String save_apple = "apple_state.txt";
        try{
            FileOutputStream file = new FileOutputStream(save_player);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(player);
            file = new FileOutputStream(save_apple);
            out = new ObjectOutputStream(file);
            out.writeObject(apple);
            out.close();
            file.close();
        }
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }
    public void load_game(){
        pause=true;
        String save_player = "player_state.txt";
        String save_apple = "apple_state.txt";
        try {
            FileInputStream file = new FileInputStream(save_player);
            ObjectInputStream in = new ObjectInputStream(file);
            player = (Player) in.readObject();
            file = new FileInputStream(save_apple);
            apple = (Apple) in.readObject();
            in.close();
            file.close();
        }
        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                    " is caught");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (player.alive && !pause) {
            player.move();
            player.eat(apple);
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    if (player.y[0] != player.y[1]-Const_size.UNIT_SIZE) player.direction = Direction.DOWN;
                    break;
                case KeyEvent.VK_UP:
                    if (player.y[0] != player.y[1]+Const_size.UNIT_SIZE) player.direction = Direction.UP;
                    break;
                case KeyEvent.VK_RIGHT:
                    if (player.x[0] != player.x[1]-Const_size.UNIT_SIZE) player.direction = Direction.RIGHT;
                    break;
                case KeyEvent.VK_LEFT:
                    if (player.x[0] != player.x[1]+Const_size.UNIT_SIZE) player.direction = Direction.LEFT;
                    break;
                case KeyEvent.VK_P:
                    if(pause) pause=false;
                    else pause = true;
                    break;
                case KeyEvent.VK_S:
                    save_game();
                    break;
                case KeyEvent.VK_L:
                    load_game();
                    break;
            }
        }
    }
}
