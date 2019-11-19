import edu.princeton.cs.algs4.*;
import java.util.Arrays;
import java.util.Random;

public class ex1
{
    public static void main(String[] args){
        int N = Integer.parseInt(args[0]);
        Point2D [] arr = new Point2D[N];
        StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.setPenRadius(.001);
        for(int i =0;i<N;i++){
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x,y);
            arr[i]=p;
            //StdDraw.point(x,y);
            p.draw();
        }
        double min = 1000;
        for(int i =0;i<N;i++){
            for(int j =i+1;j<N;j++){
                double dist = arr[i].distanceTo(arr[j]);
                min=min>dist?dist:min;
            }
        }
        StdOut.println(min);
    }
}