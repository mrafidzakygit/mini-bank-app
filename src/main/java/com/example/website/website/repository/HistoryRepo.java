package com.example.website.website.repository;

import com.example.website.website.entity.History;
import com.example.website.website.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<History, Long> {
}
