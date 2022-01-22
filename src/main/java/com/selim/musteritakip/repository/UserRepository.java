package com.selim.musteritakip.repository;

import com.selim.musteritakip.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Optional - içerinde bilgi olup olmadığını kontrol eden bir mekanizmaya sahiptir.
    // Bu nedenle kontrol işlemlerinde kullanılır.
    Optional<User> findOptionalByUsernameAndPassword(String username, String password);

}
