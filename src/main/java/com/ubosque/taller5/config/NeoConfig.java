package com.ubosque.taller5.config;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

public class NeoConfig {

    private Driver driver;

    public NeoConfig(){
        driver = GraphDatabase.driver(Constant.NeoEnv.NEO_URL,
                AuthTokens.basic(Constant.NeoEnv.NEO_USER, Constant.NeoEnv.NEO_PASS)
        );
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
