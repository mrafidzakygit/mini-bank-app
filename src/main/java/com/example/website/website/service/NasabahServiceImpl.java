package com.example.website.website.service;

import com.example.website.website.entity.Nasabah;
import com.example.website.website.repository.NasabahRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NasabahServiceImpl implements NasabahService{

    @Autowired
    private NasabahRepo nasabahRepo;


    public NasabahRepo getNasabahRepo() {
        return nasabahRepo;
    }

    public void setNasabahRepo(NasabahRepo nasabahRepo) {
        this.nasabahRepo = nasabahRepo;
    }

    @Override
    public List<Nasabah> getAll() {
        return this.nasabahRepo.findAll();
    }

    @Override
    public void save(Nasabah nasabah) {
        this.nasabahRepo.save(nasabah);
    }

    /*@Override
    public void delete(Nasabah nasabah) {
        this.nasabahRepo.delete(nasabah);
    }*/

    @Override
    public void getById(Long Id) {
        //return Optional.empty();
        this.nasabahRepo.findById(Id);
    }
}

