package com.via.repository;

import com.via.model.Obszar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObszarRepository extends JpaRepository<Obszar, Integer> {
}
