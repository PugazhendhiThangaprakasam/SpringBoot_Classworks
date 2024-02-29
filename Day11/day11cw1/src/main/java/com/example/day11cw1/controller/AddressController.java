package com.example.day11cw1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day11cw1.model.Address;

import com.example.day11cw1.service.AddressService;

@RestController
public class AddressController {
    public AddressService addressService;
    public AddressController(AddressService addressService)
    {
        this.addressService = addressService;
    }
    @PostMapping("/address/person/{personId}")
    public ResponseEntity<Address> postMethodName(@RequestBody Address address) {
        if(addressService.saveAddress(address))
        {
            return new ResponseEntity<>(address,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
