package com.example.mascotas.controller;


import com.example.mascotas.dao.MascotaDAO;
import com.example.mascotas.dto.MascotaDTO;
import com.example.mascotas.entityes.Mascota;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/mascota")
public class MascotaController {


    private MascotaDAO mascotaDAO;



    @GetMapping("/{idMascota}")
    public ResponseEntity<MascotaDTO> findMascotaById(@PathVariable("idMascota") int idMascota){


        List<Mascota> mascotasEncontradas = mascotaDAO.listarMascotas();


        for (Mascota m :
             mascotasEncontradas) {

            System.out.println(m.getNombre());

        }


        Optional<Mascota>  mascota = mascotaDAO.findById(idMascota);
        return new ResponseEntity<>(
                MascotaDTO.builder()
                        .idMascota(idMascota)
                        .nombre(mascota.get().getNombre())
                        .tipoMascota(mascota.get().getTipoMascota())
                        .propietario(mascota.get().getPropietario())
                        .build(),
        HttpStatus.OK
                        );
    }

    @PostMapping
    public ResponseEntity saveMascota(@RequestBody MascotaDTO mascotaDTO){
        //mascotaDTO.setIdMascota(mascotaDTO.getIdMascota());
        Mascota mEliminar = new Mascota(mascotaDTO.getIdMascota(),null,0,0,null,null);
        Mascota mGuardar = new Mascota(mascotaDTO.getIdMascota(),
                mascotaDTO.getNombre(),
                mascotaDTO.getTipoMascota(),
                mascotaDTO.getPropietario(),
                null, null);
        mascotaDAO.save(mGuardar);
        mascotaDAO.delete(mEliminar);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location Duvan", "/api/v1/mascota/" + mascotaDTO.getIdMascota());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }


}
