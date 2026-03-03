package myproject;
import java.util.LinkedList;
import java.awt.Point;

public class Snake {

    public int body_length;
    public LinkedList<Point> body;  
    public Direction snake_direction;
    public Point head;

    public enum Direction{
        UP,DOWN,LEFT,RIGHT
    }

    public Snake(Point startPosition){
        body=new LinkedList<>();
        body_length=3;
        snake_direction=Direction.RIGHT;

        for(int i=0;i<30;i++){
            body.add(new Point(startPosition.x - i, startPosition.y));
        }
    }

    public void Extend_body(Point body_tail,Direction dir){
        this.body_length+=1;
        if(dir==Direction.UP){
            this.body.add(new Point(body_tail.x,body_tail.y+1));
        }else if(dir==Direction.DOWN){
            this.body.add(new Point(body_tail.x,body_tail.y-1));
        }else if(dir==Direction.RIGHT){
            this.body.add(new Point(body_tail.x+1,body_tail.y));
        }else if(dir==Direction.LEFT){
            this.body.add(new Point(body_tail.x-1,body_tail.y));
        }
        return;
    }
    public Direction judge_direction_tail_of_body(LinkedList<Point> body){
        Point last_point=body.getLast();
        Point previous_last_point=body.get(body.size()-2);
        int x_level=last_point.x-previous_last_point.x;
        int y_level=last_point.y-previous_last_point.y;

        if(x_level>0){
            return Direction.RIGHT;
        }else if(x_level<0){
            return Direction.LEFT;
        }else if(y_level>0){
            return Direction.UP;
        }else if(y_level<0){
            return Direction.DOWN;
        }
        return null;
    }
}