package com.diabetestracker.exception;

public class DiabeticNotFoundException extends RuntimeException{
    public DiabeticNotFoundException(){
        super("diabetic not found !");
    }
}
