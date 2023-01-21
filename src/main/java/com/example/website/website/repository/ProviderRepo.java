package com.example.website.website.repository;

import com.example.website.website.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepo extends JpaRepository<Provider, Long> {

    Provider findByName(String name);
}
