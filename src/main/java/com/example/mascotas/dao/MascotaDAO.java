package com.example.mascotas.dao;

import com.example.mascotas.entityes.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MascotaDAO extends JpaRepository<Mascota, Integer> {




    @Query(value = "select * from mascota", nativeQuery = true)
    List<Mascota> listarMascotas();


}
