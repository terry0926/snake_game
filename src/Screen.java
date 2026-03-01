import javax.swing.*;
import java.awt.*;


class MyJFrame extends JFrame {  
    MyJFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,700, 700);
        setTitle("JFrame");
        Gampanel panel=new Gampanel();
        add(panel);
        setVisible(true);
    }
}

class Gampanel extends JPanel{
    private int x=0;
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        //WEIGHT 685 OUTBOUND(15) HEIGHT 653 OUTBOUND(47)
        this.draw_bound(700, 700, 15, g);
        g.setColor(Color.RED);
        g.fillRect(x, 0, 20, 20);

    }

    public Gampanel(){
        
        Timer timer=new Timer(30, e->{
            this.x+=2;
            repaint();
        });
        timer.start();
    }

    public void draw_bound(int x,int y,int size,Graphics g){
        int gap=x/size;
        for(int i=1;i<size-1;i++){
            g.setColor(Color.GREEN);
            g.fillRect(gap*i-26, 20,7 , 559);
        }
        for(int i=1;i<size-1;i++){
            g.setColor(Color.GREEN);
            g.fillRect(20, gap*i-26,559 , 7);
        }
        return;
    }

    
} 

public class Screen extends JPanel {
    public static void main(String[] args){
        MyJFrame x=new MyJFrame();

    }
}
