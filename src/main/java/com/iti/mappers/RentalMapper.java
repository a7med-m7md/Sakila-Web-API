package com.iti.mappers;

import com.iti.models.request.RentalRequestDto;
import com.iti.models.response.RentalResponseDto;
import com.iti.persistence.JPAFactoryManager;
import com.iti.persistence.entities.Customer;
import com.iti.persistence.entities.Inventory;
import com.iti.persistence.entities.Rental;
import com.iti.persistence.entities.Staff;
import com.iti.persistence.repository.CustomerRepository;
import com.iti.persistence.repository.InventoryRepository;
import com.iti.persistence.repository.StaffRepository;
import jakarta.persistence.EntityManager;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface RentalMapper extends BaseMapper<Rental, RentalRequestDto, RentalResponseDto>{
    EntityManager entityManager = JPAFactoryManager.createEntityManager();
    @Mapping(source = "staffId", target = "staff", qualifiedByName = "mapStaff")
    @Mapping(source = "customerId", target = "customer", qualifiedByName = "mapCustomer")
    @Mapping(source = "inventoryId", target = "inventory", qualifiedByName = "mapInventory")
    Rental toEntity(RentalRequestDto rentalRequestDto);

    RentalResponseDto toDto(Rental rental);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "staffId", target = "staff", qualifiedByName = "mapStaff")
    @Mapping(source = "customerId", target = "customer", qualifiedByName = "mapCustomer")
    @Mapping(source = "inventoryId", target = "inventory", qualifiedByName = "mapInventory")
    Rental partialUpdate(RentalRequestDto rentalRequestDto, @MappingTarget Rental rental);

    @Named("mapStaff")
    default Staff mapStaff(Integer staffId){
        if(staffId == null)
            return null;
        StaffRepository staffRepository = new StaffRepository(entityManager);
        return staffRepository.findOne(staffId).get();
    }

    @Named("mapCustomer")
    default Customer mapCustomer(Integer customerId){
        if(customerId == null)
            return null;
        CustomerRepository<Customer> customerRepository = new CustomerRepository(entityManager);
        return customerRepository.findOne(customerId).get();
    }

    @Named("mapInventory")
    default Inventory mapInventory(Integer inventoryId){
        if(inventoryId == null)
            return null;
        InventoryRepository inventoryRepository = new InventoryRepository(entityManager);
        return inventoryRepository.findOne(inventoryId).get();
    }

}