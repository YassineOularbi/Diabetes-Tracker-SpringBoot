package com.diabetestracker.exception;

public class IngredientNotFoundException extends RuntimeException{
    public IngredientNotFoundException(){
        super("ingredient not found !");
    }
}
