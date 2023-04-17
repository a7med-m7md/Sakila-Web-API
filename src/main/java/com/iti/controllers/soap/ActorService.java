//package com.iti.controllers.soap;
//
//
//import com.iti.models.response.ActorResponseDto;
//import com.iti.persistence.JPAFactoryManager;
//import jakarta.persistence.EntityManager;
//
//@WebService
//public class ActorService {
//    EntityManager entityManager;
//    ActorService actorService;
//
//    public ActorService() {
//        entityManager = JPAFactoryManager.createEntityManager();
//        actorService = new ActorService(entityManager);
//    }
//
//    @WebMethod(operationName = "getAllActors")
//    public List<ActorResponseDto> getAllActors(
//            @WebParam(name = "page") int page,
//            @WebParam(name = "size") int size) {
//        try {
//            return actorService.getAllActors(page, size);
//        } catch (Exception e) {
//            throw new WebServiceException(e);
//        }
//    }
//
//    @WebMethod(operationName = "getActor")
//    public ActorResponseDto getActor(@WebParam(name = "id") int id) {
//        try {
//            return actorService.getActor(id).get();
//        } catch (Exception e) {
//            throw new WebServiceException(e);
//        }
//    }
//
//    @WebMethod(operationName = "createActor")
//    public void createActor(@WebParam(name = "actor") Actor actor) {
//        try {
//            actorService.create(actor);
//        } catch (Exception e) {
//            throw new WebServiceException(e);
//        }
//    }
//
//    @WebMethod(operationName = "updateActor")
//    public void updateActor(@WebParam(name = "id") int id,
//                            @WebParam(name = "actor") Actor actor) {
//        try {
//            actorService.updateActor(actor, id);
//        } catch (Exception e) {
//            throw new WebServiceException(e);
//        }
//    }
//
//    @WebMethod(operationName = "getActorFilms")
//    public List<FilmResponseDto> getActorFilms(@WebParam(name = "id") int id) {
//        try {
//            return actorService.getActorFilms(id);
//        } catch (Exception e) {
//            throw new WebServiceException(e);
//        }
//    }
//
//    @WebMethod(operationName = "createFilmForActor")
//    public void createFilmForActor(@WebParam(name = "actorId") int actorId) {
//        throw new UnsupportedOperationException();
//    }
//
//    @WebMethod(operationName = "getActorOneFilm")
//    public FilmResponseDto getActorOneFilm(@WebParam(name = "actorId") int actorId,
//                                           @WebParam(name = "filmId") int filmId) {
//        try {
//            return actorService.getActorOneFilm(actorId, filmId);
//        } catch (Exception e) {
//            throw new WebServiceException(e);
//        }
//
//    }
