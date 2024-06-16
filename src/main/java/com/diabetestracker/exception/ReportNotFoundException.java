package com.diabetestracker.exception;

public class ReportNotFoundException extends RuntimeException{
    public ReportNotFoundException(){
        super("report not found !");
    }
}
