package ae.fortytwo.exceptions;

import java.lang.Exception;


public class InvalidScenarioException extends Exception {

    public static final String baseMsg = "\u001B[31mInvalid Scenario ! \u001B[0m";

    public InvalidScenarioException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage () {
        return baseMsg + super.getMessage();
    }

}