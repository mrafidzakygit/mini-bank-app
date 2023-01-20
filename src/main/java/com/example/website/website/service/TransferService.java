package com.example.website.website.service;

import com.example.website.website.entity.Transfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransferService {

    List<Transfer> getAll();

    public void save(Transfer transfer);

    public void delete(Long id);

    public void getById(Long id);
}
