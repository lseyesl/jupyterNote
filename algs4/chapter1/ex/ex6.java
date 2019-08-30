import edu.princeton.cs.algs4.*;

public class ex6
{
    public static void main(String[] args)
    {
        String a = args[0];
        String b = args[1];
        String temp = a+a;
        StdOut.println(temp.indexOf(b));
    }
}