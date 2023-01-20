package com.example.website.website.service;

import com.example.website.website.entity.Rekening;
import com.example.website.website.repository.RekeningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RekeningServiceImpl implements RekeningService{

    @Autowired
    private RekeningRepo rekeningRepo;

    @Override
    public List<Rekening> getAll() {
        return this.rekeningRepo.findAll();
    }

    @Override
    public void save(Rekening rekening) {
        this.rekeningRepo.save(rekening);
    }

    /*@Override
    public void delete(Rekening rekening) {
        this.rekeningRepo.save(rekening);
    }*/

    @Override
    public Optional<Rekening> getRekById(Long Id) {
        return this.rekeningRepo.getRekById(Id);
    }

    @Override
    public Rekening findByNoRek(String noRekening){
        return this.rekeningRepo.findByNoRekening(noRekening);
    }





}
