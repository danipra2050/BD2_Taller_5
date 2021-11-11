package com.ubosque.taller5.controller;

import com.ubosque.taller5.config.NeoConfig;
import com.ubosque.taller5.interfaces.IPets;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

public class PetController implements IPets {

    private Driver driver;

    @Override
    public int createPet(String name, String species) {
        driver = new NeoConfig().getDriver();
        try(Session session = driver.session()){
            String nodeName = name.trim().replace(" ", "").toLowerCase();
            Result result = session.run("CREATE ("+nodeName+": Pet {name: '" + name +"', species: '" + species + "'}) RETURN id("+nodeName+")");

            return result.single().get(0).asInt();
        }
    }

    @Override
    public int createPerson(String name, String owner, String mail) {
        driver = new NeoConfig().getDriver();
        try(Session session = driver.session()){
            String nodeName = name.trim().replace(" ", "").toLowerCase();
            Result result = session.run("CREATE ("+nodeName+": Person {name: '" + name +"', owner: '" + owner + "', mail: '"+ mail +"'}) RETURN id("+nodeName+")");

            return result.single().get(0).asInt();
        }
    }

    @Override
    public int createPhoto(String name, String urlPhoto) {
        driver = new NeoConfig().getDriver();
        try(Session session = driver.session()){
            String nodeName = name.trim().replace(" ", "").toLowerCase();
            Result result = session.run("CREATE ("+nodeName+": Photo {url: '" + urlPhoto +"'}) RETURN id("+nodeName+")");

            return result.single().get(0).asInt();
        }
    }

    @Override
    public void petRelation(String petName, String ownerName) {
        driver = new NeoConfig().getDriver();
        try(Session session = driver.session()){
            Result result = session.run("MATCH (mascota:Pet) WHERE mascota.name = '"+petName+"'"+
                    "MATCH (persona:Person) WHERE persona.name = '"+ ownerName +"' " +
                    "CREATE(mascota)-[:BELONGS]->(persona)");
        }
    }
}
