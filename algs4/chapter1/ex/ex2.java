import edu.princeton.cs.algs4.*;

public class ex2
{
    public static void main(String[] args)
    {
        int T = Integer.parseInt(args[0]);
        Interval1D[] arr = new Interval1D[T];
        int aNum = 0;
        for(int i= 1;i<args.length;i+=2)
        {
            Interval1D a = new Interval1D(Double.parseDouble(args[i]),Double.parseDouble(args[i+1]));
            arr[aNum]=a;
            aNum++;
        }
        for(int i =0;i<aNum;i++){
            for(int j = i+1;j<aNum;j++){
                if(arr[i].intersects(arr[j])){
                    StdOut.println(arr[i]);
                    StdOut.println(arr[j]);
                    StdOut.println("-----------");
                }
            }
        }
    }
}