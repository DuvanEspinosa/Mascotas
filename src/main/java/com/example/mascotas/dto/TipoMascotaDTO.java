package com.example.mascotas.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoMascotaDTO {


    private int idTipoMascota;
    private String descripcion;
}
