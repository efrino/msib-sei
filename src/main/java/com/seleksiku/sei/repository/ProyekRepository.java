package com.seleksiku.sei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seleksiku.sei.entity.Proyek;

@Repository
public interface ProyekRepository extends JpaRepository<Proyek, Long> {
}
