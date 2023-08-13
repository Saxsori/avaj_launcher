package ae.fortytwo.exceptions;

import java.lang.Exception;


public class ParsingErrorException extends Exception {

    public static final String baseMsg = "\u001B[31mParse Error ! \u001B[0m";

    public ParsingErrorException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage () {
        return baseMsg + super.getMessage();
    }

}