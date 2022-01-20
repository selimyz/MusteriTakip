package com.selim.musteritakip.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MusteriSaveDto {

    // NOT!
    // Değişkenlere ait zorunlulukların aktif olabilmesi için bu sınıfı kullanacak olan
    // method içinde @Valid annotasyonu kullanılmalıdır.
    @Size(min = 3)
    @NotNull
    String ad;
    @Size(min = 3, message = "Lütfen Minimum 3 karakter olacak şekilde soyadını giriniz")
    @NotNull
    String soyad;
    String adres;

    // Controller tarafında, html ya da rest isteği alarak gelen
    // request lerin json olarak handle edilmesi için bu
    // JsonCreator annotasyonu eklenir

    @JsonCreator
    public MusteriSaveDto(String ad, String soyad, String adres) {
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
