package com.example.mascotas.entityes;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {



        @Id
        @Column(name = "id_mascota")
        private int idMascota;
        @Column(name = "nombre")
        private String nombre;
        @Column(name = "tipo_Mascota")
        private int tipoMascota;
        @Column(name = "propietario")
        private int propietario;



        @ManyToOne
        @JoinColumn(name = "tipo_Mascota", updatable = false ,insertable = false)
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Mascota mascotas;

    @ManyToOne
    @JoinColumn(name = "propietario", updatable = false ,insertable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Propietario propietarios;





}
