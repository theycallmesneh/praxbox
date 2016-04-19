import java.util.*;

/*
Assumptions:
- 8-bit chip code
- data will either be 1 or 0
*/

public class CDMA
{
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String args[])
	{
		int d; //data
		String chip_code; // chip code in string format
		Sender A, B;
		
		System.out.print("Enter Ad: ");
		d = in.nextInt();
		System.out.print("Enter A's 8-bit chip code (separate with ','): ");
		chip_code = in.next();
		A = new Sender('A',d,chip_code);
		
		System.out.print("Enter Bd: ");
		d = in.nextInt();
		System.out.print("Enter B's 8-bit chip code (separate with ','): ");
		chip_code = in.next();
		B = new Sender('B',d,chip_code);
		
		int Cs[] = Sender.add(A,B);
		
		System.out.println("A's Recovered data: "+A.recoverFrom(Cs));
		System.out.println("B's Recovered data: "+B.recoverFrom(Cs));
		System.out.println("\n\n::DATA_DUMP::\n\n");
		System.out.println(A);
		System.out.println("\n\n");
		System.out.println(B);
	}
}

class Sender // "Senders" for A and B
{
	char name; // sender name
	int d; // data bit
	int bi_d; //bipolar version
	int chip_code[], bi_chip_code[];
	int spread_data[]; //spread data

	public Sender(char name,int d, String chip_code_str)
	{
		this.name = name;
		this.d = d;
		this.bi_d = getBipolar(d);
		this.chip_code = getCode(chip_code_str);
		this.bi_chip_code = getBiCode(chip_code_str);
		this.spread_data = getSpreadData();
	}
	
	public int[] getSpreadData()
	{
		int data[] = new int[8];
		int ccn; //temp var for chip code number
		for (int i = 0; i < 8; i++)
		{
			data[i] = this.bi_d*this.bi_chip_code[i];
		}
		
		return(data);
	}
	
	public int[] getCode(String str_code)
	{
		int code[] = new int[8];
		
		Scanner s = new Scanner(str_code);
		s.useDelimiter(",");
		for (int i = 0; i < 8 && s.hasNext(); i++)
		{
			code[i] = s.nextInt();
		}
		
		return(code);
	}
	
	public int[] getBiCode(String str_code)
	{
		int code[] = new int[8];
		
		Scanner s = new Scanner(str_code);
		s.useDelimiter(",");
		for (int i = 0; i < 8 && s.hasNext(); i++)
		{
			code[i] = getBipolar(s.nextInt());
		}
		
		return(code);
	}
	
	public static int[] add(Sender A, Sender B)
	{
		int data[] = new int[8];
		
		for (int i = 0; i < 8; i++)
		{
			data[i] = A.spread_data[i]+B.spread_data[i];
		}
		
		return(data);
	}
	
	public int recoverFrom(int arr[])
	{
		int sum = 0;
		int res;
		
		for (int i = 0; i < 8; i++)
		{
			sum = sum + (this.bi_chip_code[i]*arr[i]);
		}
		
		if (sum > 0)
		{
			res = 1;
		}
		else
		{
			res = 0;
		}
		
		return(res);
	}
	
	public static int getBipolar(int n)
	{
		int ret = 1;
		
		if (n > 0)
		{
			ret = 1;
		}
		else
		{
			ret = -1;
		}
		
		return(ret);
	}
	
	public String toString()
	{
		String op = "";
		op = op+this.name+"'s INFO: \n";
		op = op+"- Given Data: "+this.d+"\n";
		op = op+"- Bipolar version of Data: "+this.bi_d+"\n";
		op = op+"- Chip Code: ";
		for (int i = 0; i < 8; i++)
		{
			op = op+this.chip_code[i]+" ";
		}
		op = op+"\n";
		op = op+"- Bipolar Chip Code: ";
		for (int i = 0; i < 8; i++)
		{
			op = op+this.bi_chip_code[i]+" ";
		}
		op = op+"\n";
		return(op);
	}
}
