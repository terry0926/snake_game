package myproject;
import java.awt.Point;
import java.util.LinkedList;

public class Boundary {
    private int size;
    private Point body_head;

    public enum signal{
        continous,gameover
    }

    public Boundary(int map_size,LinkedList<Point> body){
        this.size=map_size;
        this.body_head=body.get(0);
    }

    public Boundary.signal game_signal(){
        if(this.body_head.x>this.size || this.body_head.y>this.size){
            return Boundary.signal.gameover;
        }
        else if(this.body_head.x<0 || this.body_head.y<0){
            return Boundary.signal.gameover;
        }
        else{
            System.out.printf("1");
            return Boundary.signal.continous;
        }
    }
    
    public void _change_boday_head(Point head){
        this.body_head=head;
        return;
    }
}
