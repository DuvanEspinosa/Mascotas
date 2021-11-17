package com.example.mascotas.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MascotaDTO {



    private int idMascota;
    private String nombre;
    private int tipoMascota;
    private int propietario;
}
