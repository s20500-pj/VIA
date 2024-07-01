package com.via.repository;

import com.via.model.Dzialanie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DzialanieRepository extends JpaRepository<Dzialanie, Integer> {
}
