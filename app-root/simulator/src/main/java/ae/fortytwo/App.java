package ae.fortytwo;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import ae.fortytwo.Parser.Parser;
import ae.fortytwo.Simulator;

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
			
			Simulator simulator = new Simulator();
			
			File outputFile = new File("simulation.txt");
			
			// Create a FileOutputStream for the output file
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            // Create a PrintStream that writes to the FileOutputStream
            PrintStream printStream = new PrintStream(fileOutputStream);
            // Redirect the System.out to the custom PrintStream
            System.setOut(printStream);

			simulator.launch();

            printStream.close();
            fileOutputStream.close();
		}
		catch (Exception e) {
			System.out.println("App Throws an Exception !\n" + e.getMessage());
			// e.printStackTrace();
		}
    }
}
