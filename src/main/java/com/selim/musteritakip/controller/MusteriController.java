package com.selim.musteritakip.controller;

import com.selim.musteritakip.dto.request.MusteriSaveDto;
import com.selim.musteritakip.dto.response.MusteriResponseDto;
import com.selim.musteritakip.repository.entity.Musteri;
import com.selim.musteritakip.service.MusteriServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.selim.musteritakip.constants.RestApiUrls.*;

@RestController // Bu sınıfın bir RestApi hizmeti sunacağını belirtir
@RequestMapping(VERSION + MUSTERI) // Kullanıcıların isteklerini yakalayacak adresi tanımlıyoruz
@Api(value = "Müşteri İşlemleri Servisi")
public class MusteriController {

    // Otomatik nesne oluşturma
    @Autowired
    MusteriServices musteriServices;

    /**
     * Bu Method Çağrıldığında (http://localhost:9090/v1/musteri/save)
     * Dikkat edilmesi gereken konu;
     * Bu Method bir POST methoddur yani browser a yazarak çalıştıramazsınız
     *
     * @param ad
     * @param soyad
     * @param adres
     * @return
     */

    @PostMapping(SAVE)
    @ApiOperation(value = "Müşteri Kayıt")
    public ResponseEntity<Void> save(String ad, String soyad, String adres) {
        musteriServices.save(Musteri.builder().ad(ad).soyad(soyad).adres(adres).build());
        return ResponseEntity.ok().build();
    }

    /**
     * NOT!!! burada istermciler tarafından istenilecek parametrelerin
     * JsonArray seklinde talep edilebilmesi için öncelikle talep edilen
     * sınıf başına @RequestBody annotasyonu getirilmelidir.
     * Eğer var ise ilgili sınıf içinde bulunan zorunlulukların aktif olarak
     * kontrol edilmesi için @Valid annotasyonu eklenmelidir.
     *
     * @param dto
     * @return
     */
    @PostMapping("/savedto")
    @ApiOperation(value = "Dto ile Müşteri Kayıt Etmek")
    public ResponseEntity<Void> saveDto(@RequestBody @Valid MusteriSaveDto dto) {
        // NOT!! lütfen dto kayıt işlemlerini controller içinde yapmayın
        // DB kayıt işlemleri için kullanılarak kısım servisleridir.
        musteriServices.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FINDALL)
    @ApiOperation(value = "Tüm Müşterileri Listeleme")
    public ResponseEntity<List<Musteri>> findAll() {
        return ResponseEntity.ok(musteriServices.findAll());
    }

    @GetMapping("/findallresponse")
    @ApiOperation(value = "Tüm Müşterilerin DTO şeklinde dönülmesi")
    public ResponseEntity<List<MusteriResponseDto>> findAllResponse() {
        return ResponseEntity.ok(musteriServices.findAllResponse());
    }

    @GetMapping("/findallad")
    @ApiOperation(value = "Tüm Müşterilerin DTO şeklinde dönülmesi")
    public ResponseEntity<List<Musteri>> findAllAd(String ad) {
        return ResponseEntity.ok(musteriServices.findAllName(ad));
    }
}
