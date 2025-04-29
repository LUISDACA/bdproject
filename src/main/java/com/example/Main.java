package com.example;

import java.util.List;
import java.util.Optional;
import com.example.model.Actor;
import com.example.repository.ActorRepository;

public class Main {
    public static void main(String[] args) {
        ActorRepository repository = new ActorRepository();
        
        try {
            System.out.println("*ALL ACTORS*");
            repository.findAll().forEach(actor -> 
                System.out.printf("%d - %s %s%n", 
                    actor.getActorID(), 
                    actor.getFirstName(), 
                    actor.getLastName())
            );
            
            System.out.println("\n*ACTOR ID*");
            Optional.ofNullable(repository.getByID(100))
                .ifPresentOrElse(
                    actor -> System.out.printf("%d - %s %s%n", 
                        actor.getActorID(), 
                        actor.getFirstName(), 
                        actor.getLastName()),
                    () -> System.out.println("actor not found")
                );
            
            System.out.println("\n*INSERTING NEW ACTOR*");
            repository.save(new Actor(200, "Luis", "Miguel"));
            
            System.out.println("\n*UPDATING EXISTING ACTOR*");
            repository.save(new Actor(200, "WER", "QWE"));
            
            System.out.println("\n*ELIMINATING ACTOR*");
            repository.delete(201);
            
        } catch (Exception e) {
            System.err.println("Connection or query error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}