package com.cardealership.cardealership.Services;

import org.springframework.stereotype.Service;
import com.cardealership.cardealership.infrastructure.CustomerAddressesRepository;
import com.cardealership.cardealership.models.CustomerAddresses;

@Service
public class CustomerAddressesService {
    private final CustomerAddressesRepository repository;

    public CustomerAddressesService(CustomerAddressesRepository repository) {
        this.repository = repository;
    }

    public CustomerAddresses addAddress(CustomerAddresses address) {
        // Validate customer exists
        //validateCustomerExists(address.getCustomerId());

        // If setting as primary, remove other primary addresses
        if (Boolean.TRUE.equals(address.getIsPrimary())) {
            removePrimaryFlag(address.getCustomerId());
        }

        // Validate address fields
        validateAddressFields(address);

        return repository.save(address);
    }

    public void deleteAddress(Long addressId, Long customerId) {
        // Verify address exists and belongs to customer
        var address = repository.findById(addressId)
            .orElseThrow(() -> new IllegalArgumentException("Address not found"));
        
        if (!address.getCustomerId().equals(customerId)) {
            throw new IllegalArgumentException("Address does not belong to customer");
        }
        // If primary address, throw error or reassign primary
        if (Boolean.TRUE.equals(address.getIsPrimary())) {
            handlePrimaryAddressDeletion(customerId, addressId);
        }

        repository.deleteByAddressId(addressId);
    }

    private void validateAddressFields(CustomerAddresses address) {
        if (address.getLine1() == null || address.getLine1().trim().isEmpty()) {
            throw new IllegalArgumentException("Address line 1 is required");
        }
        if (address.getCity() == null || address.getCity().trim().isEmpty()) {
            throw new IllegalArgumentException("City is required");
        }
        if (address.getState() == null || address.getState().trim().isEmpty()) {
            throw new IllegalArgumentException("State is required");
        }
        if (address.getPostalCode() == null || address.getPostalCode().trim().isEmpty()) {
            throw new IllegalArgumentException("Postal code is required");
        }
        if (address.getCountry() == null || address.getCountry().trim().isEmpty()) {
            throw new IllegalArgumentException("Country is required");
        }
    }

    private void handlePrimaryAddressDeletion(Long customerId, Long addressId) {
        // Logic to handle primary address deletion
        throw new IllegalArgumentException("Cannot delete primary address without reassigning another primary");
    }

    private void removePrimaryFlag(Long customerId) {
        var primaryAddresses = repository.findByCustomerIdAndIsPrimaryTrue(customerId);
        for (var address : primaryAddresses) {
            address.setIsPrimary(false);
            repository.save(address);
        }
    }
}