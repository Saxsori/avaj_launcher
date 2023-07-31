package ae.fortytwo;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("boo! " + args[0]);
		// File file = new File("test/scenario.txt");
		File file = new File(args[0]);
		try {
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				System.out.println(data);
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.out.print("Error: ");
			e.printStackTrace();
		}
    }
}
