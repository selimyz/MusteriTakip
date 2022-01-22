package com.selim.musteritakip.service;

import com.selim.musteritakip.dto.request.MusteriSaveDto;
import com.selim.musteritakip.dto.response.MusteriResponseDto;
import com.selim.musteritakip.mapper.MusteriMapper;
import com.selim.musteritakip.repository.entity.Musteri;
import com.selim.musteritakip.repository.MusteriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 1- Servis ler class olarak eklenir
 * 2- Sınıfın üzerine @Service annotastonu eklenmelidir.
 */

@Service
public class MusteriService {

    // NOT: Repository ler sınıf değildir. bu nedenle new lenemezler
    // Spring kendi interface ve diğer sınıflardan nesne üretmek için
    // @Autowired annotasyonunu kullanır. Eğer bunu eklemez iseniz
    // nesne null döneceği için hata alırsınız

    @Autowired
    MusteriRepository musteriRepository;

    @Autowired
    MusteriMapper musteriMapper;

    public void save(Musteri musteri){
        musteriRepository.save(musteri);
    }
    public void update(Musteri musteri){
        musteriRepository.save(musteri);
    }
    public void delete(Musteri musteri){
        musteriRepository.delete(musteri);
    }
    public List<Musteri> findAll(){
        return musteriRepository.findAll();
    }
    public void save(MusteriSaveDto dto){
        // Burada dto şeklinde gelen müşteri bilgisinin Mapper ile müşteri
        // nesnesine çevrilmesi sağlanmış ve kayıt işlemi tamamlanmıştır.
        Musteri musteri = musteriMapper.toMusteri(dto);
        musteriRepository.save(musteri);
    }
    public List<MusteriResponseDto> findAllResponse(){
        List<MusteriResponseDto> result = new ArrayList<>();
        for (Musteri musteri: musteriRepository.findAll()){
            result.add(musteriMapper.forMusteri(musteri));
        }
        return result;
    }
    public List<Musteri> findAllName(String ad){
        return musteriRepository.findByAdLike(ad);
    }
}
