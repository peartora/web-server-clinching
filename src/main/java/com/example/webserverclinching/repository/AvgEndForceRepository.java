package com.example.webserverclinching.repository;

import com.example.webserverclinching.entity.AvgEndForce;
import com.example.webserverclinching.entity.ClinchingDmc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AvgEndForceRepository extends JpaRepository<AvgEndForce, Long> {

    List<AvgEndForce> findByClinchingTypeAndMfdBetween(String clinchingType, LocalDateTime start, LocalDateTime end);

}
