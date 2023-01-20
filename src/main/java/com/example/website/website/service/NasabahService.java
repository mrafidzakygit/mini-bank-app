package com.example.website.website.service;

import com.example.website.website.entity.Nasabah;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface NasabahService {

    public List<Nasabah> getAll();

    public void save(Nasabah nasabah);

    /*public void delete(Nasabah nasabah);*/

    public void getById(Long Id);
}
