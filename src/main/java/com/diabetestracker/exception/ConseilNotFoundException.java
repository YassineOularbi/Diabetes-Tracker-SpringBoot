package com.diabetestracker.exception;

public class ConseilNotFoundException extends RuntimeException{
    public ConseilNotFoundException(){
        super("conseil not found !");
    }
}
