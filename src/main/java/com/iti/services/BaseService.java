//package com.iti.services;
//
//import jakarta.persistence.EntityManager;
//import org.mapstruct.factory.Mappers;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//public abstract class BaseService<Entity, Request, Response, Mapper> {
//    protected final EntityManager entityManager;
//    protected final Mapper mapper;
//
//    public BaseService(EntityManager entityManager, Class<Mapper> mapperClass) {
//        this.entityManager = entityManager;
//        this.mapper = Mappers.getMapper(mapperClass);
//    }
//
//    protected abstract Class<Entity> getEntityClass();
//
//    public List<Response> getAll(int page, int size) {
//        List<Entity> entities = entityManager.createQuery("SELECT e FROM " + getEntityClass().getSimpleName() + " e")
//                .setFirstResult((page - 1) * size)
//                .setMaxResults(size)
//                .getResultList();
//        return entities.stream().map(mapper::toResponseDto).collect(Collectors.toList());
//    }
//
//    public Optional<Response> getById(int id) {
//        Entity entity = entityManager.find(getEntityClass(), id);
//        return entity != null ? Optional.of(mapper.toResponseDto(entity)) : Optional.empty();
//    }
//
//    public Response create(Request requestDto) {
//        Entity entity = mapper.toEntity(requestDto);
//        entityManager.persist(entity);
//        entityManager.flush();
//        return mapper.toResponseDto(entity);
//    }
//
//    public Optional<Response> update(int id, Request requestDto) {
//        Entity entity = entityManager.find(getEntityClass(), id);
//        if (entity != null) {
//            mapper.updateFromRequestDto(requestDto, entity);
//            return Optional.of(mapper.toResponseDto(entity));
//        }
//        return Optional.empty();
//    }
//
//    public boolean delete(int id) {
//        Entity entity = entityManager.find(getEntityClass(), id);
//        if (entity != null) {
//            entityManager.remove(entity);
//            return true;
//        }
//        return false;
//    }
//}
