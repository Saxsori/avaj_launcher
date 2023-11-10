package ae.fortytwo;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import ae.fortytwo.Parser.Parser;
import ae.fortytwo.Simulator;
import ae.fortytwo.exceptions.ParsingErrorException;

public class App 
{

    public static void main( String[] args )
    {
		try {
			if (args.length != 1)
				throw new ParsingErrorException("Arguments Error: There are more than one file or no file provided");

			File file = new File(args[0]);


			Scanner reader = new Scanner(file);
			ArrayList<String> lineList = new ArrayList<>();
			
			if (!reader.hasNextLine())
				throw new ParsingErrorException("File Error: File is empty");
			
			while (reader.hasNextLine()) {	
				String data = reader.nextLine();
				if (lineList.size() < Integer.MAX_VALUE - 1)
					lineList.add(data);
			}
			reader.close();
			
			Parser parse = new Parser(lineList);
			if (!parse.isValid)
				throw new ParsingErrorException("Validition failed: The Scenario is not valid");
			
			
			File outputFile = new File("./simulation.txt");
			
			// Create a FileOutputStream for the output file
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            // Create a PrintStream that writes to the FileOutputStream
            PrintStream printStream = new PrintStream(fileOutputStream);
            // Redirect the System.out to the custom PrintStream
            System.setOut(printStream);

			Simulator simulator = new Simulator();
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
