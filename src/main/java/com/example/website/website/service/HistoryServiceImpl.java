package com.example.website.website.service;

import com.example.website.website.entity.History;
import com.example.website.website.entity.Rekening;
import com.example.website.website.entity.Transfer;
import com.example.website.website.repository.HistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class HistoryServiceImpl implements HistoryService{

    @Autowired
    private HistoryRepo historyRepo;


    @Override
    public List<History> getAll() {
        return this.historyRepo.findAll();
    }

    @Override
    public void save(Transfer transfer, Rekening penerima,
                     Rekening pengirim) {
        LocalDateTime dateTime = LocalDateTime.now();
        History history = new History();
        history.setPengirim(pengirim.getNoRekening());
        history.setPenerima(penerima.getNoRekening());
        history.setTglKirim(dateTime);
        history.setJumlah(transfer.getJumlah());
        this.historyRepo.save(history);


    }
}
