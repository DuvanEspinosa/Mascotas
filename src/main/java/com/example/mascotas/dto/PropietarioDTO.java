package com.example.mascotas.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropietarioDTO {


    private int idPropietario;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
}
