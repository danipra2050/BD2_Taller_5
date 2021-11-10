package com.ubosque.taller5.controller;

import com.ubosque.taller5.config.NeoConfig;
import com.ubosque.taller5.interfaces.IPets;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

public class PetController implements IPets {

    private Driver driver;

    @Override
    public boolean createPet(String specie) {
        return false;
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
    public boolean createPhoto() {
        return false;
    }
}
