package com.seleksiku.sei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seleksiku.sei.entity.Lokasi;

@Repository
public interface LokasiRepository extends JpaRepository<Lokasi, Long> {
}
