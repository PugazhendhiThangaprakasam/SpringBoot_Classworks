package com.example.day11cw1.service;




import org.springframework.stereotype.Service;

import com.example.day11cw1.model.Address;
import com.example.day11cw1.repository.AddressRepository;

@Service
public class AddressService {
    public AddressRepository addressRepository;
    public AddressService(AddressRepository addressRepository)
    {
        this.addressRepository = addressRepository;
    }
    public boolean saveAddress(Address address)
    {
        try
        {
            addressRepository.save(address);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    
}
