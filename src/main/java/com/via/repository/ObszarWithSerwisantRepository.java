package com.via.repository;

import com.via.model.ObszarWithSerwisantView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObszarWithSerwisantRepository extends JpaRepository<ObszarWithSerwisantView, Integer> {
}
