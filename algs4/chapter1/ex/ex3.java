import edu.princeton.cs.algs4.*;
import java.util.Arrays;
import java.util.Random;

public class ex3
{
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        int min = Integer.parseInt(args[1]);
        int max = Integer.parseInt(args[2]);
        Interval2D[] arr = new Interval2D[N];
        double[][] pot =new double[N][4];
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(.005);
        StdDraw.setXscale(0,30);
        StdDraw.setYscale(0,30);

        for(int i =0;i<N;i++){
            double x1 = (double)Math.random()*(max-min)+min;
            double x2 = (double)Math.random()*(max-min)+min;
            double y1 = (double)Math.random()*(max-min)+min;
            double y2 = (double)Math.random()*(max-min)+min;
            Interval1D x = new Interval1D(x1>x2?x2:x1,x1>x2?x1:x2);
            Interval1D y = new Interval1D(y1>y2?y2:y1,y1>y2?y1:y2);
            pot[i][0]=x.min();
            pot[i][1]=x.max();
            pot[i][2]=y.min();
            pot[i][3]=y.max();
            Interval2D temp = new Interval2D(x,y);
            arr[i]=temp;
            temp.draw();
        }
        int InNum = 0;
        for(int i =0;i<N;i++){
            for(int j = i+1;j<N;j++){
                if(arr[i].intersects(arr[j])){
                    InNum++;
                    StdOut.println(arr[i]);
                    StdOut.println(arr[j]);
                    StdOut.println("***********");
                    StdOut.println(arr[i].hashCode());
                    StdOut.println("=================");
                }
            }
        }
        int cNum = 0;
        for(int i = 0;i<N;i++){
            for(int j =0;j<N;j++){
                if(i!=j){
                    Point2D p = new Point2D(pot[j][0],pot[j][1]);
                    Point2D p2 = new Point2D(pot[j][2],pot[j][3]);
                    if(arr[i].contains(p)&&arr[i].contains(p2)){
                        cNum++;
                    }
                }
            }
        }
        StdOut.println(InNum);
        StdOut.println(cNum);
    }
}