package spring.exception;

public class NutrientNotFoundException extends RuntimeException{
    public NutrientNotFoundException(){
        super("nutrient not found !");
    }
}
