import java.util.*;

public class FreqReuse
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner( System.in);
		int n,i,j,tf,fc,tc,cc;
		System.out.println("enter the value of i and j");
		i = sc.nextInt();
		j=sc.nextInt();
		System.out.println("enter the total available frequency");
		tf=sc.nextInt();
		System.out.println("enter the total channels per cluster");
		tc=sc.nextInt();
		n=(i*i)+(i*j)+(j*j);
		fc= (tf/n);
		cc= (tc/n);
		System.out.println("The number of cells per cluster: "+n);
		System.out.println("The frequency per cell : "+fc);
		System.out.println("The channels per cell : "+cc);
	}
}
