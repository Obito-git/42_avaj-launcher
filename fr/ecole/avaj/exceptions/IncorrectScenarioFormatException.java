package fr.ecole.avaj.exceptions;

public class IncorrectScenarioFormatException extends Exception {
    public IncorrectScenarioFormatException(String errorMessage) {
        super(errorMessage);
    }

    public IncorrectScenarioFormatException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
