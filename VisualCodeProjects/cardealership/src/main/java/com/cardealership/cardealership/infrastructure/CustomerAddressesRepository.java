package com.cardealership.cardealership.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import com.cardealership.cardealership.models.CustomerAddresses;
import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface CustomerAddressesRepository extends JpaRepository<CustomerAddresses, Long> {
    
    // Find all addresses for a specific customer
    List<CustomerAddresses> findByCustomerId(Long customerId);
    
    // Find primary address of a customer
    List<CustomerAddresses> findByCustomerIdAndIsPrimaryTrue(Long customerId);
    
    // Find addresses by type for a customer
    List<CustomerAddresses> findByCustomerIdAndAddressType(Long customerId, String addressType);
    
    // Find addresses by city
    List<CustomerAddresses> findByCity(String city);
    
    // Count addresses per customer
    Long countByCustomerId(Long customerId);
    
    // Check if customer has primary address
    boolean existsByCustomerIdAndIsPrimaryTrue(Long customerId);
    
    // Delete all addresses for a customer
    @Modifying
    @Transactional
    void deleteByCustomerId(Long customerId);

    // Delete an specific address by its ID
    @Modifying
    @Transactional
    void deleteByAddressId(Long addressId);
}