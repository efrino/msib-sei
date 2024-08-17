package com.seleksiku.sei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleksiku.sei.entity.Proyek;
import com.seleksiku.sei.exception.ResourceNotFoundException;
import com.seleksiku.sei.repository.ProyekRepository;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    public Proyek getProyekById(Long proyekId) {
        return proyekRepository.findById(proyekId)
            .orElseThrow(() -> new ResourceNotFoundException("Proyek not found for this id :: " + proyekId));
    }

    public Proyek addProyek(Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    public Proyek updateProyek(Long proyekId, Proyek proyekDetails) {
        Proyek proyek = getProyekById(proyekId);

        proyek.setNamaProyek(proyekDetails.getNamaProyek());
        proyek.setClient(proyekDetails.getClient());
        proyek.setTglMulai(proyekDetails.getTglMulai());
        proyek.setTglSelesai(proyekDetails.getTglSelesai());
        proyek.setPimpinanProyek(proyekDetails.getPimpinanProyek());
        proyek.setKeterangan(proyekDetails.getKeterangan());
        proyek.setLokasiSet(proyekDetails.getLokasiSet());

        return proyekRepository.save(proyek);
    }

    public void deleteProyek(Long proyekId) {
        Proyek proyek = getProyekById(proyekId);
        proyekRepository.delete(proyek);
    }
}
