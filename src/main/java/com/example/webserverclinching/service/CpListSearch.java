package com.example.webserverclinching.service;

import com.example.webserverclinching.entity.ClinchingDmc;
import com.example.webserverclinching.repository.DmcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CpListSearch {

    private final DmcRepository dmcRepository;

    public List<ClinchingDmc> returnClinchingCp(List<String> dmcs, String clinchingType)
    {
        return dmcRepository.findByDmcInAndClinchingType(dmcs, clinchingType);
    }
}
