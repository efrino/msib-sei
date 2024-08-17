package com.seleksiku.sei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seleksiku.sei.entity.Lokasi;
import com.seleksiku.sei.service.LokasiService;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @PostMapping
    public Lokasi addLokasi(@RequestBody Lokasi lokasi) {
        return lokasiService.addLokasi(lokasi);
    }

    @GetMapping
    public List<Lokasi> getAllLokasi() {
        return lokasiService.getAllLokasi();
    }

    @PutMapping("/{id}")
    public Lokasi updateLokasi(@PathVariable Long id, @RequestBody Lokasi lokasiDetails) {
        return lokasiService.updateLokasi(id, lokasiDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLokasi(@PathVariable Long id) {
        lokasiService.deleteLokasi(id);
    }
}
