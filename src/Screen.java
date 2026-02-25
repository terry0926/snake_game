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
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

    } 
} 

public class Screen extends JPanel {
    public static void main(String[] args){
        MyJFrame x=new MyJFrame();
    }
}
