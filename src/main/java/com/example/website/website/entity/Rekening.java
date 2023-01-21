package com.example.website.website.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rekening")
public class Rekening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String noRekening;

    private double saldo = 1000000.0;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "nasabah_id", referencedColumnName = "id")
    private Nasabah nasabah;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", referencedColumnName = "id")
    private Provider provider;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pengirim", cascade = CascadeType.ALL)
    private List<Transfer> rekPengirim;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "penerima", cascade = CascadeType.ALL)
    private List<Transfer> rekPenerima;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Nasabah getNasabah() {
        return nasabah;
    }

    public void setNasabah(Nasabah nasabah) {
        this.nasabah = nasabah;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<Transfer> getRekPengirim() {
        return rekPengirim;
    }

    public void setRekPengirim(List<Transfer> rekPengirim) {
        this.rekPengirim = rekPengirim;
    }

    public List<Transfer> getRekPenerima() {
        return rekPenerima;
    }

    public void setRekPenerima(List<Transfer> rekPenerima) {
        this.rekPenerima = rekPenerima;
    }


}
