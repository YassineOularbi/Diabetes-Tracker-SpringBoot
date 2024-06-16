package com.diabetestracker.exception;

public class RecipeNotFoundException extends RuntimeException{
    public RecipeNotFoundException(){
        super("recipe not found !");
    }
}
