package com.via.repository;

import com.via.model.Serwisant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerwisantRepository extends JpaRepository<Serwisant, Integer> {
}
