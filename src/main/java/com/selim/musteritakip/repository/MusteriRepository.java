package com.selim.musteritakip.repository;

import com.selim.musteritakip.repository.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 1- Repository Interface olmalı
 * 2- JpaRepository den miras almalı
 * 3- Repository hangi sınıfı kullanıyor ise o jpa ya verilmeli
 * 4- ID nin türü ne ise(String, Long, Integer v.s) JPA ya eklenmeli
 * 5- @Repository annotasyonu eklenmeli
 * NOT: bir şey eksik ise, hiç açılmaz ya da çalışma zamanında repository
 * null döndü diye hata verir
 */

@Repository
public interface MusteriRepository extends JpaRepository<Musteri, Long> {

    // Kişinin adına göre arama
    // Adına ve Soyadına göre arama
    List<Musteri> findByAdLike(String ad);
    // Bu şekilde özel methodlar yazarken dikkat edilmesi gereken hususlar
    // 1- findBy ile başlayın
    // 2- Değişken adlarını yazarken ilk harfler büyük olmalı zira bu şekilde
    // analiz edebiliyor. Bu arada değişken adları, Entity de olan değişken isimleridir.
    // burada kullanılan keyword ler spring tarafından desteklenen anahtar kelimeler olmalıdır.
    List<Musteri> findByAdAndSoyad(String ad, String soyad);

}
