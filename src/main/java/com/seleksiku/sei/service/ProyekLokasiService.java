package com.seleksiku.sei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleksiku.sei.entity.ProyekLokasi;
import com.seleksiku.sei.exception.ResourceNotFoundException;
import com.seleksiku.sei.repository.ProyekLokasiRepository;

@Service
public class ProyekLokasiService {

    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    public List<ProyekLokasi> getAllProyekLokasi() {
        return proyekLokasiRepository.findAll();
    }

    public ProyekLokasi getProyekLokasiById(Long proyekLokasiId) {
        return proyekLokasiRepository.findById(proyekLokasiId)
            .orElseThrow(() -> new ResourceNotFoundException("ProyekLokasi not found for this id :: " + proyekLokasiId));
    }

    public ProyekLokasi addProyekLokasi(ProyekLokasi proyekLokasi) {
        return proyekLokasiRepository.save(proyekLokasi);
    }

    public ProyekLokasi updateProyekLokasi(Long proyekLokasiId, ProyekLokasi proyekLokasiDetails) {
        ProyekLokasi proyekLokasi = getProyekLokasiById(proyekLokasiId);

        proyekLokasi.setProyek(proyekLokasiDetails.getProyek());
        proyekLokasi.setLokasi(proyekLokasiDetails.getLokasi());

        return proyekLokasiRepository.save(proyekLokasi);
    }

    public void deleteProyekLokasi(Long proyekLokasiId) {
        ProyekLokasi proyekLokasi = getProyekLokasiById(proyekLokasiId);
        proyekLokasiRepository.delete(proyekLokasi);
    }
}

