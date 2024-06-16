package com.diabetestracker.exception;

public class RepasNotFoundException extends RuntimeException{
    public RepasNotFoundException(){
        super("repas not found !");
    }
}
