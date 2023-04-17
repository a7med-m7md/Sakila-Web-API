package com.iti.services;

import com.iti.mappers.BaseMapper;
import com.iti.persistence.entities.Payment;
import com.iti.persistence.repository.BaseRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseService<RequestDto, ResponseDto, Entity> {
    private final BaseRepository<Entity> repository;
    private final BaseMapper<Entity, RequestDto,ResponseDto> mapper;

    public BaseService(BaseRepository<Entity> repository, BaseMapper<Entity, RequestDto, ResponseDto> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ResponseDto> findAll(int page, int size) {
        List<Entity> entities = repository.findAll(page, size);
        return  entities.stream().map(entity -> mapper.toDTO(entity)).collect(Collectors.toList());
    }

    public ResponseDto findById(int id) {
        Optional<Entity> entityOptional = repository.findOne(id);
        System.out.println(entityOptional);
        return entityOptional.map(entity -> mapper.toDTO(entity)).stream().findFirst().get();
    }

    public void save(RequestDto requestDto) {
        Entity entity = mapper.toEntity(requestDto);
        repository.create(entity);
    }

    public void update(RequestDto requestDto, int id) {
        Entity entity = repository.findOne(id).get();
        System.out.println(entity);
        Entity entity_ = mapper.partialUpdate(requestDto, entity);
        System.out.println(entity_);
        repository.update(entity_);
        System.out.println("===>>");
    }

    public void deleteById(int id) {
        Optional<Entity> entity =  repository.findOne(id);
        repository.deleteById(entity.get());
    }
}
