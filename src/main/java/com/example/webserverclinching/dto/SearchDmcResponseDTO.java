package com.example.webserverclinching.dto;

import com.example.webserverclinching.entity.ClinchingDmc;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class SearchDmcResponseDTO {

    private String dmc;

    private String clinchingType;

    private LocalDateTime mfd;

    private boolean operationResult;

    //private Boolean monitoringResult;

    public static SearchDmcResponseDTO of(ClinchingDmc entity) {
        return SearchDmcResponseDTO.builder()
                .dmc(entity.getDmc())
                .clinchingType(entity.getClinchingType())
                .mfd(entity.getMfd())
                .operationResult(entity.isOperationResult())
                //.monitoringResult(entity.isMonitoringResult())
                .build();
    }
}
