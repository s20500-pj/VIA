package com.via.repository;

import com.via.model.DzialaniaForSerwisantView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DzialaniaForSerwisantRepository extends JpaRepository<DzialaniaForSerwisantView, Integer> {
}
