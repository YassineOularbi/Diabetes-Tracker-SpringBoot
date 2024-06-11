package com.diabetestracker.exception;

public class GlycemieNotFoundException extends RuntimeException{
    public GlycemieNotFoundException(){
        super("glycemie not found !");
    }
}
