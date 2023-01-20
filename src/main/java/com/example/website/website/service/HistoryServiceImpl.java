package com.example.website.website.service;

import com.example.website.website.entity.History;
import com.example.website.website.entity.Transfer;
import com.example.website.website.repository.HistoryRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService{
    private HistoryRepo historyRepo;


    @Override
    public List<History> getAll() {
        return this.historyRepo.findAll();
    }

    @Override
    public void save(Transfer transfer) {

    }
}
