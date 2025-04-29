package com.example;

import java.util.List;

import com.example.model.Actor;
import com.example.repository.ActorRepository;

public class Main {
    public static void main(String[] args) {
        try {
            ActorRepository repository = new ActorRepository();

            System.out.println("==== TODOS LOS ACTORES ====");
            List<Actor> allActors = repository.findAll();
            for (Actor actor : allActors) {
                System.out.println(actor.getActorID() + " - " + actor.getFirstName() + " " + actor.getLastName());
            }

            System.out.println("\n==== ACTOR POR ID ====");
            Actor actorById = repository.getByID(100); 
            if (actorById != null) {
                System.out.println(actorById.getActorID() + " - " + actorById.getFirstName() + " " + actorById.getLastName());
            } else {
                System.out.println("Actor no encontrado.");
            }

            
            System.out.println("\n==== INSERTANDO NUEVO ACTOR ====");
            Actor nuevo = new Actor(200, "Luis", "Miguel");
            repository.save(nuevo);

            
            System.out.println("\n==== ACTUALIZANDO ACTOR EXISTENTE ====");
            Actor actualizado = new Actor(200, "WER", "QWE");
            repository.save(actualizado);

            
            System.out.println("\n==== ELIMINANDO ACTOR ====");
            repository.delete(201);

        } catch (Exception e) {
            System.out.println("Error de conexión o consulta: " + e.getMessage());
            e.printStackTrace();
        }
    }
}