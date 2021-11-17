package com.example.mascotas.entityes;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class TipoMascota {


    @Id
    @Column(name = "idTipoMascota")
    private int idTipoMascota;
    @Column(name = "descripcion")
    private String descripcion;



    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy="mascotas")
    private List<Mascota> mascotas;
}
