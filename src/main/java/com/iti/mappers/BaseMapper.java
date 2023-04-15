package com.iti.mappers;

public interface BaseMapper<Table, DTO> {
    DTO toDTO(Table table);
    Table toEntity(DTO dto);
}
