package com.example.webserverclinching.repository;

import com.example.webserverclinching.entity.ClinchingDmc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DmcRepository extends JpaRepository<ClinchingDmc, Long> {

    //List<ClinchingDmc> findByMfdBetween(LocalDateTime start, LocalDateTime end);
    //List<ClinchingDmc> findByClinchingTypeAndMfdBetween(String clinchingType, LocalDateTime start, LocalDateTime end);
    //List<ClinchingDmc> findByOperationResultAndMfdBetween(String operationResult, LocalDateTime start, LocalDateTime end);
    //List<ClinchingDmc> findByMonitoringResultAndMfdBetween(String monitoringResult, LocalDateTime start, LocalDateTime end);

    //List<ClinchingDmc> findByClinchingTypeAndOperationResultAndMfdBetween(String clinchingType, String operationResult, LocalDateTime start, LocalDateTime end);
    List<ClinchingDmc> findByClinchingTypeAndOperationResultAndMfdBetween(String clinchingType, boolean operationResult, LocalDateTime start, LocalDateTime end);



    //List<ClinchingDmc> findByClinchingTypeAndMonitoringResultAndMfdBetween(String clinchingType, String monitoringResult, LocalDateTime start, LocalDateTime end);
    //List<ClinchingDmc> findByOperationResultAndMonitoringResultAndMfdBetween(String operationResult, String monitoringResult, LocalDateTime start, LocalDateTime end);
    //List<ClinchingDmc> findByClinchingTypeAndOperationResultAndMonitoringResultAndMfdBetween(String clinchingType, String operationResult, String monitoringResult, LocalDateTime start, LocalDateTime end);

    @Query("SELECT DISTINCT dmc FROM ClinchingDmc dmc JOIN FETCH dmc.cps WHERE dmc.dmc IN :dmcs AND dmc.clinchingType = :type")
    List<ClinchingDmc> findByDmcInAndClinchingType(@Param("dmcs") List<String> dmcs, @Param("type") String clinchingType);
}
