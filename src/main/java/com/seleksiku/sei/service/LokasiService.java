package com.seleksiku.sei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleksiku.sei.entity.Lokasi;
import com.seleksiku.sei.exception.ResourceNotFoundException;
import com.seleksiku.sei.repository.LokasiRepository;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    public Lokasi getLokasiById(Long lokasiId) {
        return lokasiRepository.findById(lokasiId)
            .orElseThrow(() -> new ResourceNotFoundException("Lokasi not found for this id :: " + lokasiId));
    }

    public Lokasi addLokasi(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    public Lokasi updateLokasi(Long lokasiId, Lokasi lokasiDetails) {
        Lokasi lokasi = getLokasiById(lokasiId);

        lokasi.setNamaLokasi(lokasiDetails.getNamaLokasi());
        lokasi.setNegara(lokasiDetails.getNegara());
        lokasi.setProvinsi(lokasiDetails.getProvinsi());
        lokasi.setKota(lokasiDetails.getKota());

        return lokasiRepository.save(lokasi);
    }

    public void deleteLokasi(Long lokasiId) {
        Lokasi lokasi = getLokasiById(lokasiId);
        lokasiRepository.delete(lokasi);
    }
}
