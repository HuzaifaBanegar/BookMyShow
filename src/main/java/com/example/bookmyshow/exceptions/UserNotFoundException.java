package com.example.bookmyshow.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }

    /*
    Unchecked exceptions / RuntimeException: No need to handle
        NullPointerException
        ArrayIndexOutOfBoundsException
        IllegalArgumentException
    Checked Exception: Handle it using try catch
        IOException
        SQLException
        ClassNotFoundException
    */
}
