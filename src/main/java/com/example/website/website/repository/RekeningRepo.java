package com.example.website.website.repository;

import com.example.website.website.entity.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RekeningRepo extends JpaRepository<Rekening, Long> {

    Rekening findByNoRekening(String noRekening);

    Optional<Rekening> getRekById(Long id);
}
