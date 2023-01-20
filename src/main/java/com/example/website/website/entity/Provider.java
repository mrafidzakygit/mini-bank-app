package com.example.website.website.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "nameprovider")
    private String name;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "provider")
    private List<Rekening> rekenings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rekening> getRekenings() {
        return rekenings;
    }

    public void setRekenings(List<Rekening> rekenings) {
        this.rekenings = rekenings;
    }


}
