package com.example.website.website.service;

import com.example.website.website.entity.Rekening;
import com.example.website.website.entity.Transfer;
import com.example.website.website.repository.RekeningRepo;
import com.example.website.website.repository.TransferRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransferServiceImpl implements TransferService{

    @Autowired
    TransferRepo transferRepo;

    @Autowired
    RekeningRepo rekeningRepo;
    @Autowired
    RekeningService rekeningService;

    double newSaldo;

    double saldo;

    @Override
    public List<Transfer> getAll(){
        return this.transferRepo.findAll();
    }

    @Override
    public void save(Transfer transfer) {
        Rekening rekeningPengirim = rekeningService.findByNoRek(transfer.getPengirim().getNoRekening());
        Rekening rekeningPenerima = rekeningService.findByNoRek(transfer.getPenerima().getNoRekening());

        Long idPengirim = rekeningPengirim.getId();
        Long idPenerima = rekeningPenerima.getId();

        Optional<Rekening> pengirim = this.rekeningService.getRekById(idPengirim);
        Optional<Rekening> penerima = this.rekeningService.getRekById(idPenerima);

        Rekening rekPengirim = pengirim.get();
        Rekening rekPenerima = penerima.get();

        String bankAsal = rekPengirim.getProvider().getName();
        String bankTuju = rekPenerima.getProvider().getName();

        Transfer transfer1 = new Transfer();
        transfer1.setTglkirim(Date.valueOf(LocalDate.now()));
        transfer1.setJumlah(transfer.getJumlah());

        if(bankAsal.equals(bankTuju)) {
            rekPengirim.setSaldo(rekPengirim.getSaldo()-(transfer.getJumlah()));
            System.out.println(rekPengirim.getSaldo());
            transfer1.setPengirim(rekPengirim);
            transfer1.setPenerima(rekPenerima);
            rekPenerima.setSaldo(rekPenerima.getSaldo() + (transfer1.getJumlah()));
            this.rekeningRepo.save(rekPengirim);
            this.rekeningRepo.save(rekPenerima);
            this.transferRepo.save(transfer1);
        }else if(bankAsal != bankTuju) {
            double fee = 6500;
            System.out.println(transfer1.getJumlah());
            rekPengirim.setSaldo((rekPengirim.getSaldo())-(transfer.getJumlah())- (fee));
            transfer1.setFee(6500);
            transfer1.setPengirim(rekPengirim);
            transfer1.setPenerima(rekPenerima);
            rekPenerima.setSaldo(rekPenerima.getSaldo() + (transfer1.getJumlah()));
            this.rekeningRepo.save(rekPengirim);
            this.rekeningRepo.save(rekPenerima);
            this.transferRepo.save(transfer1);
        }
    }
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        this.rekeningRepo.deleteById(id);
    }

    @Override
    public void getById(Long id) {
        // TODO Auto-generated method stub
        this.rekeningRepo.findById(id);
    }

}
