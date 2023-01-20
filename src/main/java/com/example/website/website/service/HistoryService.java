package com.example.website.website.service;

import com.example.website.website.entity.History;
import com.example.website.website.entity.Transfer;

import java.util.List;

public interface HistoryService {

    List<History> getAll();

    public void save(Transfer transfer);
}
