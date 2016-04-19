import java.io.*;
import java.util.*;
class expt1
{
	public static void main(String args[]) throws IOException
	{
	int i=0;
    int line=0;
    int space=0; 
    try 
    {
	FileReader fr=new FileReader("test.txt");  
    FileWriter fw=new FileWriter("testwrite.txt");
    
    while((i=fr.read())!=-1)
    {
    	System.out.print((char)i); 
    	if (i=='\n')
    	line++;
    	else if (i==32)
    	space++;
     }
   
    fw.write("Number of lines = " +line +" \n Number of spaces=" +space);
    fw.close();
    fr.close();
    }
    
    catch(FileNotFoundException e)
{
System.out.println("File doesnot exist");
}
    } 
}  
