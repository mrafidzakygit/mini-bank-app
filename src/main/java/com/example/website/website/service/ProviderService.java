package com.example.website.website.service;

import com.example.website.website.entity.Provider;
import com.example.website.website.repository.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProviderService {

    @Autowired
    private ProviderRepo providerRepo;


    public void save(Provider provider) {
        this.providerRepo.save(provider);

    }
    public List<Provider>getAll(){

        return this.providerRepo.findAll();
    }

    public Optional<Provider> getById(Long Id) {

        return this.providerRepo.findById(Id);
    }

    public Provider findByName(String name) {
        return this.providerRepo.findByName(name);
    }
}
