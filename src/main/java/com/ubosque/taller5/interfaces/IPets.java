package com.ubosque.taller5.interfaces;

public interface IPets {

    int createPet(String name, String specie);

    int createPerson(String name, String owner, String mail);

    int createPhoto(String name, String urlPhoto);

    void petRelation(String petName, String ownerName);
}
