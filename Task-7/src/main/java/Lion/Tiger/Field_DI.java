package Lion.Tiger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component

public class Field_DI {
   // Field Dependency Injection
    @Autowired
    private Engine engine;
    public void drive() {
        engine.start();
        System.out.println("Car is moving from field DI...");

    }

 }