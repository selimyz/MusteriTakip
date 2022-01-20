package com.selim.musteritakip.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;

public class MusteriResponseDto {

    String ad;

    @JsonCreator
    public MusteriResponseDto(String ad) {
        this.ad = ad;
    }

    public MusteriResponseDto() {
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
