package ae.fortytwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

import ae.fortytwo.Parser.Parser;

public class App 
{
    public static void main( String[] args )
    {
		if (args.length != 1)
		{
			// ! Exception should be thrown here
			System.out.println("Error ! There are more than one file or no file provided");
			return ;
		}

		System.out.println( "Hello World!" );
        System.out.println("boo! " + args[0]);

		File file = new File(args[0]);

		try {

			Scanner reader = new Scanner(file);
			Deque<String> linesStack = new ArrayDeque<>();
			// ! if the file is empty throw an exception here
			for (int i = -1; reader.hasNextLine(); ++i) {
				
				String data = reader.nextLine();
				linesStack.push(data);
				System.out.println(data);
			}
			reader.close();
			Parser parse = new Parser(linesStack);
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
    }
}
