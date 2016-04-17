import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
 

public class mpst 
{
    public static void main(String[] args) 
    {
    	int sent=0, ws=0;
    	String[] MOT = {"L", "LH", "LM", "LR", "ST", "STH", "A", "AH", "AR", "C", "CR", "D", "BALR", "BAL", "MR", "M"};
      String[] POT={"START","USING","DC","DS","END"};
      String [] ST={"BEGIN","OLDB","DEPO","WITH","NEWB"};
        try 
        {
            FileReader reader = new FileReader("assembly.txt");
            FileWriter writer = new FileWriter("MOT.txt", true);
            BufferedReader bufferedReader = new BufferedReader(reader);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            
             
            String line;
 
            while ((line = bufferedReader.readLine()) != null) 
            {       
              String[] result = line.split("\\s");     
              
    				for (int x=0; x<result.length; x++)
    				{
    					for(int i=0; i< MOT.length; i++)
    					{
      						if(result[x].equals(MOT[i]))
      						{
      							bufferedWriter.write("\n"+result[x]+" ");
      							bufferedWriter.write("\n");
      							break;
      						}
      						
    					}
    				}
            }
            reader.close();
            bufferedWriter.close();
 				  writer = new FileWriter("POT.txt", true);
       reader = new FileReader("assembly.txt");
       
       bufferedReader =new BufferedReader(reader);
       bufferedWriter = new BufferedWriter(writer);
       
            while ((line = bufferedReader.readLine()) != null) 
            {       
              String[] result = line.split("\\s");     
              
    				for (int x=0; x<result.length; x++)
    				{
    					for(int i=0; i< POT.length; i++)
    					{
      						if(result[x].equals(POT[i]))
      						{
      							bufferedWriter.write("\n"+result[x]);
      							bufferedWriter.write("\n");
      							break;
      						}
      						
    					}
    				}
 	
       }
       	     reader.close();
 		           bufferedWriter.close();
        writer = new FileWriter("ST.txt", true);
       reader = new FileReader("assembly.txt");
       
       bufferedReader =new BufferedReader(reader);
       bufferedWriter = new BufferedWriter(writer);
       
            while ((line = bufferedReader.readLine()) != null) 
            {       
              String[] result = line.split("\\s");     
              
    				for (int x=0; x<result.length; x++)
    				{
    					for(int i=0; i< ST.length; i++)
    					{
      						if(result[x].equals(ST[i]))
      						{
      							bufferedWriter.write("\n"+result[x]+" ");
      							bufferedWriter.write("\n");
      							break;
      						}
      						
    					}
    				}
 	
       }
       	     reader.close();
 		           bufferedWriter.close();
       
 
 
 			
     
        } catch (IOException e) {
            e.printStackTrace();
        }
      
 	}
}
