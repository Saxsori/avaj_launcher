package ae.fortytwo;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

import ae.fortytwo.Parser.Parser;

public class App 
{
    public static void main( String[] args )
    {
		try {
			if (args.length != 1)
				throw new Exception("Error: There are more than one file or no file provided");

			File file = new File(args[0]);


			Scanner reader = new Scanner(file);
			ArrayList<String> lineList = new ArrayList<>();
			
			if (!reader.hasNextLine())
				throw new Exception("File Error: File is empty");
			
			while (reader.hasNextLine()) {	
				String data = reader.nextLine();
				lineList.add(data);
				// System.out.println(data);
			}
			reader.close();
			Parser parse = new Parser(lineList);
			if (!parse.isValid)
				throw new Exception("Exit Program: The Scenario is not valid");
			
			

		}
		catch (Exception e) {
			System.out.println("App Throws an Exception !\n" + e.getMessage());
			// e.printStackTrace();
		}
    }
}
