package ae.fortytwo.Parser;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;


public class Parser 
{
	private Deque<String> lines = new ArrayDeque<>();

    public Parser ( Deque<String> linesStack) {
        this.lines = linesStack;
        System.out.println("\n here from parser constructor");
        Iterator<String> descendingIterator = this.lines.descendingIterator();
        while (descendingIterator.hasNext()) {
            String line = descendingIterator.next();
            System.out.println(line);
        }
    }

    
    

}