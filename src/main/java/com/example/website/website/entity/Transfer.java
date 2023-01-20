package com.example.website.website.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Rekening pengirim;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Rekening penerima;

    private Date tglkirim;

    private double jumlah;

    private double fee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rekening getPengirim() {
        return pengirim;
    }

    public void setPengirim(Rekening pengirim) {
        this.pengirim = pengirim;
    }

    public Rekening getPenerima() {
        return penerima;
    }

    public void setPenerima(Rekening penerima) {
        this.penerima = penerima;
    }

    public Date getTglkirim() {
        return tglkirim;
    }

    public void setTglkirim(Date tglkirim) {
        this.tglkirim = tglkirim;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
