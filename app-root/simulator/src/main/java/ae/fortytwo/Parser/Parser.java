package ae.fortytwo.Parser;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.lang.Integer;

import ae.fortytwo.Parser.POJO.Scenario;
import ae.fortytwo.Parser.Validator;

public class Parser 
{
	private Deque<String> lines = new ArrayDeque<>();
	private final char delimiter = ' ';
	private Deque<Scenario> scenarios = new ArrayDeque<>();
	private Validator validator = new Validator();

    public Parser ( Deque<String> linesStack) {
        this.lines = linesStack;
        System.out.println("\n here from parser constructor");
        Iterator<String> descendingIterator = this.lines.descendingIterator();
        while (descendingIterator.hasNext()) {
            String line = descendingIterator.next();
            System.out.println(line);
        }

		this.start();
    }

	private String parseSimulations(String line) {
		System.out.println("Here where to parse the simulations");

		String [] parts = line.split(String.valueOf(this.delimiter));
		if (parts.length != 1) {
			// ! throw an exception here
			System.out.println("Error ! The simulations line doesn't contain only one number");
			return null ;
		}
		return parts[0];
		// try {
		// 	if (Integer.parseInt(parts[0]) < 1) {
		// 		// ! throw an exception here
		// 		System.out.println("Error ! The simulations string should be positive number");
		// 		return ;
		// 	}
		// }
		// catch (Exception e) {
		// 	System.out.println("Error ! The simulations string is not int" + e.getMessage());
		// 	e.printStackTrace();
		// }
	}

	private void start() {
		System.out.println("Here where to start the parse");

		// ! parse the first line
		String simulations = this.parseSimulations(this.lines.removeLast());
		// try {
			int number = this.validator.validateSimulations(simulations);
			System.out.println("The number of simulations is: " + number);
		// }

	}


    
    

}