package com.selim.musteritakip.mapper;

import com.selim.musteritakip.dto.request.MusteriSaveDto;
import com.selim.musteritakip.dto.response.MusteriResponseDto;
import com.selim.musteritakip.repository.entity.Musteri;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Doğası gereği bir sınıfın diğer bir sınıfa map edilerek dönüşümü sırasında
 * tüm alanların eşleşmesi beklenemez bu nedenle eşleşmeyen alanların görmezden
 * gelinmesi gereklidir. Bunu sağlamak için IGNORE politikası seçilir.
 * Mapstruct farklı kullanımlarda farklı şekilde setting yapılandırılmaları gerektirir.
 * Bu nedenle bileşen modeli olarak "spring" seçilmiştir. diğer kullanımlar için
 * Mapstruct ın kendi sitesinde belirtilen örneklere bakınız.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface MusteriMapper {

    // Burada işlem, istek olarak gelen musteri kısıt bilgisinden yeni bir müşteri
    // nesnesi oluşturulması durumudur.
    Musteri toMusteri(final MusteriSaveDto musteriSaveDto);

    // Bir müşterinin kısıt bilgilerinin sunulması için dto ya çevrilmesi durumudur
    MusteriResponseDto forMusteri(final Musteri musteri);
}
