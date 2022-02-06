package com.example.webserverclinching.service;

import com.example.webserverclinching.entity.ClinchingCp;
import com.example.webserverclinching.entity.ClinchingDmc;
import com.example.webserverclinching.repository.DmcRepository;
import com.example.webserverclinching.dto.SearchDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DmcListSearch {

    private final DmcRepository dmcRepository;

    public List<ClinchingDmc> returnClinchingDmc(SearchDataDTO dto) {

        return this.dmcRepository.findByClinchingTypeAndOperationResultAndMfdBetween(
                dto.getClinchingType(),
                dto.isOperationResult(),
                dto.getStart(),
                dto.getEnd());
    }
}

//        if ((dto.getClinchingType().equals("ALL")) && (dto.getOperationResult().equals("ALL")) && (dto.getMonitoringResult().equals("ALL"))) {
//            return this.dmcRepository.findByMfdBetween(dto.getStart(), dto.getEnd());
//        } else if ((dto.getOperationResult().equals("ALL")) && (dto.getMonitoringResult().equals("ALL"))) {
//            return this.dmcRepository.findByClinchingTypeAndMfdBetween(dto.getClinchingType(), dto.getStart(), dto.getEnd());
//        } else if ((dto.getClinchingType().equals("ALL")) && (dto.getMonitoringResult().equals("ALL"))) {
//            return this.dmcRepository.findByOperationResultAndMfdBetween(dto.getOperationResult(), dto.getStart(), dto.getEnd());
//        } else if ((dto.getClinchingType().equals("ALL")) && (dto.getOperationResult().equals("ALL"))) {
//            return this.dmcRepository.findByMonitoringResultAndMfdBetween(dto.getMonitoringResult(), dto.getStart(), dto.getEnd());
//        } else if ((dto.getMonitoringResult().equals("ALL"))) {
//            return this.dmcRepository.findByClinchingTypeAndOperationResultAndMfdBetween(dto.getClinchingType(), dto.getOperationResult(), dto.getStart(), dto.getEnd());
//        } else if ((dto.getOperationResult().equals("ALL"))) {
//            return this.dmcRepository.findByClinchingTypeAndMonitoringResultAndMfdBetween(dto.getClinchingType(), dto.getMonitoringResult(), dto.getStart(), dto.getEnd());
//        } else if ((dto.getClinchingType().equals("ALL"))) {
//            return this.dmcRepository.findByOperationResultAndMonitoringResultAndMfdBetween(dto.getOperationResult(), dto.getMonitoringResult(), dto.getStart(), dto.getEnd());
//        } else {
//            return this.dmcRepository.findByClinchingTypeAndOperationResultAndMonitoringResultAndMfdBetween(dto.getClinchingType(), dto.getOperationResult(), dto.getMonitoringResult(), dto.getStart(), dto.getEnd());
//        }

