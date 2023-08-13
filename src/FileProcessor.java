import java.io.*;
import java.util.*;

public class FileProcessor {

	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList;
	private Scanner input;
	
	public FileProcessor(String fileName, int stringLength) {
		setFileName(fileName);
		setStringLength(stringLength);	
	}//end constructor
		
	public void setStringList(ArrayList<String> stringList) {
		this.stringList = stringList;
	}//end setStringList

	public int getArrayListSize() {
		return stringList.size();
	}//end getArrayListSize
	
	public Scanner getInput() {
		return input;
	}//end getInput

	public void setInput(Scanner input) {
		this.input = input;
	}//end setInput

	public String getFileName() {
		return fileName;
	}//end getFileName

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}//end setFileName

	public int getStringLength() {
		return stringLength;
	}//end getStringLength

	public void setStringLength(int stringLength) {
		if(stringLength < 5) {
			this.stringLength = 5;
		}else {
		this.stringLength = stringLength;
		}
	}//end setStringLength


	public void processFile() throws StringTooLongException{
		FileReader fr = null; 
		BufferedReader reader = null; 
		
		try {
			fr = new FileReader(fileName);//creates the filereader
			reader = new BufferedReader(fr);//here is the file to read
			String line; //instantiates a line for the reader to set data into
					
			while((line = reader.readLine()) != null) { //as long as a line has text (!= null), do ... ; when it reaches the end, it will find null
				if(line.length() > stringLength){ 
					throw new StringTooLongException("The string is too long!");
				}//end if
			}//end while
			reader.close();
			System.out.println("The file has been processed successfully.");
		}//end try
		catch(IOException e) { //also catches FileNotFound exception
			System.out.println(e.getMessage());
		}//end catch for IOException
		
	
	}//end processFile
}//end class
