package com.example.webserverclinching.service;

import com.example.webserverclinching.dto.SearchDataForVisual;
import com.example.webserverclinching.entity.AvgEndForce;
import com.example.webserverclinching.entity.ClinchingDmc;
import com.example.webserverclinching.repository.AvgEndForceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvgEndForceSearch {

    private final AvgEndForceRepository avgEndForceRepository;

    public List<AvgEndForce> returnAvgEndForce(SearchDataForVisual dto)
    {
        return avgEndForceRepository.findByClinchingTypeAndMfdBetween(dto.getClinchingType(), dto.getStart(), dto.getEnd());
    }
}
