package com.ubosque.taller5.resource;

import com.ubosque.taller5.config.Constant;
import com.ubosque.taller5.controller.LoginController;
import com.ubosque.taller5.controller.PetController;
import com.ubosque.taller5.model.Request;
import com.ubosque.taller5.model.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class PetResource {

    private final PetController petController = new PetController();
    private final LoginController loginController = new LoginController();
    private Response response = null;

    @POST
    @Path("/createperson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(Request request){
        int result = petController.createPerson(request.getName(), request.getOwner(), request.getMail());
        if(result != 0){
            response = new Response(
                    Constant.Response.SUCCESS_COD,
                    Constant.Response.SUCCESS_MSG,
                    "Person create with id: " + result);
        }else{
            response = new Response(
                    Constant.Response.ERROR_COD,
                    Constant.Response.ERROR_MSG,
                    null);
        }
        return response;
    }

    @POST
    @Path("/createpet")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPet(Request request){
        int result = petController.createPet(request.getName(), request.getSpecie());
        if(result != 0){
            response = new Response(
                    Constant.Response.SUCCESS_COD,
                    Constant.Response.SUCCESS_MSG,
                    "Pet create with id: " + result);
        }else{
            response = new Response(
                    Constant.Response.ERROR_COD,
                    Constant.Response.ERROR_MSG,
                    null);
        }
        return response;
    }

    @POST
    @Path("/createphoto")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPhoto(Request request){
        int result = petController.createPhoto(request.getName(), request.getUrlPhoto());
        if(result != 0){
            response = new Response(
                    Constant.Response.SUCCESS_COD,
                    Constant.Response.SUCCESS_MSG,
                    "Pet create with id: " + result);
        }else{
            response = new Response(
                    Constant.Response.ERROR_COD,
                    Constant.Response.ERROR_MSG,
                    null);
        }
        return response;
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Request request){
        String result = loginController.login(request.getMail());
        if(!result.isEmpty()){
            response = new Response(
                    Constant.Response.SUCCESS_COD,
                    Constant.Response.SUCCESS_MSG,
                    "Welcome: " + result);
        }else{
            response = new Response(
                    Constant.Response.ERROR_COD,
                    Constant.Response.ERROR_MSG,
                    null);
        }
        return response;
    }
}
