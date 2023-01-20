package com.example.website.website.service;

import com.example.website.website.entity.Rekening;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RekeningService {
    public List<Rekening> getAll();
    public void save(Rekening rekening);
    /*public void delete(Rekening rekening);*/
    public Optional<Rekening> getRekById(Long Id);

    public Rekening findByNoRek(String noRekening);


}
