package edu.eci.cvds.tdd.registry;

public class AgeExceptions extends Exception{
    public static String ageInvalid = "The age is invalid";
    public AgeExceptions(String message) {
        super(message);
    }
}
