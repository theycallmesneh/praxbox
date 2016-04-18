import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class motpot 
{ 
	public static void main(String[] args)
	{ 
		int sent=0, ws=0; 
		 String[] MOT = {"L", "LH","S","LM", "LR", "ST", "STH", "A", "AH", "AR", "C", "CR", "D", "BCR", "BALR", "BAL", "MR", "M"};
		 String[] POT={"START","USING","DC","DS","END"};

		try 
		{ 
			FileReader reader = new FileReader("in.txt");
			FileWriter writer = new FileWriter("mot.txt", true); 
			BufferedReader Rd = new BufferedReader(reader);
			BufferedWriter Wr= new BufferedWriter(writer);
			String line;
		 
			while ((line = Rd.readLine()) != null) 
			{ 
				String[] result = line.split("\\s"); 
		 
				for (int x=0; x<result.length; x++) 
				{ 
					for(int i=0; i< MOT.length; i++)
					{
						if(result[x].equals(MOT[i]))
						{ 
							Wr.write(result[x]); 
							Wr.newLine(); 
							break; 
						} 
						
					} 
				} 
			}
			
			Rd.close();
			Wr.close(); 
			
			writer = new FileWriter("pot.txt", true); 
			reader = new FileReader("in.txt");
			Rd =new BufferedReader(reader);
			Wr = new BufferedWriter(writer);
			
			while ((line = Rd.readLine()) != null) 
			{ 
				String[] result = line.split("\\s");
				for (int x=0; x<result.length; x++)
				{ 
					for(int i=0; i< POT.length; i++)
					{ 
						if(result[x].equals(POT[i]))
						{ 
							Wr.write(result[x]); 
							Wr.newLine();
							break; 
						} 
					} 
				} 
			}
			 
			Rd.close(); 
			Wr.close(); 
			
			writer = new FileWriter("s.txt", true);
			reader = new FileReader("in.txt");
			
			Rd =new BufferedReader(reader); 
			Wr = new BufferedWriter(writer);
			
			while ((line = Rd.readLine()) != null) 
			{ 
				String[] result = line.split("\\s");
				for (int x=0; x<result.length; x++) 
				{ 
					for(int i=0; i< POT.length; i++) 
					{ 
						if(result[x].equals(POT[i])) 
						{ 
							Wr.write(result[x]); 
							Wr.newLine(); 
							break; 
						} 
					} 
				} 
			} 
			
			Rd.close();
			Wr.close(); 
		} 
		catch (IOException e) 
		{ 
			e.printStackTrace(); 
		} 
	} 
}
