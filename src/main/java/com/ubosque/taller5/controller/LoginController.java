package com.ubosque.taller5.controller;

import com.ubosque.taller5.config.NeoConfig;
import com.ubosque.taller5.interfaces.ILogin;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;

public class LoginController implements ILogin {

    private Driver driver;

    @Override
    public String login(String mail) {
        driver = new NeoConfig().getDriver();
        try(Session session = driver.session()){
            Result result = session.run("MATCH (persona:Person) WHERE persona.mail = '"+mail+"' RETURN persona.name");
            return result.single().get(0).asString();
        }catch (Exception ex){
            return null;
        }
    }
}
