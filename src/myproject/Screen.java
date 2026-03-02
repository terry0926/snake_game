package myproject;

import javax.swing.*;
import java.awt.*;




class MyJFrame extends JFrame {  
    MyJFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,714, 737);
        setTitle("JFrame");
        Gampanel panel=new Gampanel();
        add(panel);
        setVisible(true);
    }
}

class Gampanel extends JPanel{
    private int x=0;
    private Snake snake=new Snake(new Point(9,9));
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        //WEIGHT 685 OUTBOUND(15) HEIGHT 653 OUTBOUND(47)
        this.draw_bound(714, 737, 15, g);
        g.setColor(Color.RED);
        g.fillRect(x, 0, 20, 20);
        this.draw_snake(7, 7,47 , 40,12, g);
        g.setColor(Color.RED);
        g.fillRect(7, 7, 40, 40);
        

    }

    public Gampanel(){
        snake.snake_direction=Snake.Direction.UP;
        snake.head=snake.body.get(0);
        Timer timer=new Timer(300, e->{
            switch(snake.snake_direction){
                case RIGHT:
                    snake.body.add(0,new Point(snake.head.x+1,snake.head.y));
                    snake.body.removeLast();
                    break;
                case LEFT:
                    snake.body.add(0,new Point(snake.head.x-1,snake.head.y));
                    snake.body.removeLast();
                    break;
                case UP:
                    snake.body.add(0,new Point(snake.head.x,snake.head.y-1));
                    snake.body.removeLast();
                    break;
                case DOWN:
                    snake.body.add(0,new Point(snake.head.x,snake.head.y+1));
                    snake.body.removeLast();
                    break;                
            }
            x+=2;
            snake.head=snake.body.get(0);
            repaint();
        });
        timer.start();
    } 

    public void draw_bound(int x,int y,int size,Graphics g){
        for(int i=0;i<size-1;i++){
            g.setColor(Color.GREEN);
            g.fillRect(0+47*i, 0,7 , 618);
        }
        for(int i=0;i<size-1;i++){
            g.setColor(Color.GREEN);
            g.fillRect(0, 0+47*i,618 , 7);
        }
        return;
    }

    public void draw_snake(int coordinary_x,int coordinary_y,int each_coordinary_gap,int square_size,int gap_quantity,Graphics g){
        for(int i=0;i<this.snake.body.size();i++){
        g.setColor(Color.blue);
        g.fillRect(coordinary_x+this.snake.body.get(i).x*each_coordinary_gap, coordinary_y+this.snake.body.get(i).y*each_coordinary_gap,square_size,square_size);
        }
    }
    
} 

public class Screen extends JPanel {
    public static void main(String[] args){
        MyJFrame x=new MyJFrame();

    }
}
