package com.example.webserverclinching.controller;

import com.example.webserverclinching.dto.SearchDataForVisual;
import com.example.webserverclinching.dto.SearchDmcResponseDTO;
import com.example.webserverclinching.entity.AvgEndForce;
import com.example.webserverclinching.entity.ClinchingDmc;
import com.example.webserverclinching.service.AvgEndForceSearch;
import com.example.webserverclinching.service.CpListSearch;
import com.example.webserverclinching.service.DmcListSearch;
import com.example.webserverclinching.dto.SearchDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final DmcListSearch dmcListSearch;
    private final CpListSearch cpListSearch;
    private final AvgEndForceSearch avgEndForceSearch;

    @GetMapping("/search-dmc")
    public List<SearchDmcResponseDTO> searchDmc(SearchDataDTO dto)
    {
        return this.dmcListSearch.returnClinchingDmc(dto).stream()
                .map(SearchDmcResponseDTO::of).collect(Collectors.toList());
    }

    @GetMapping("/make-visualize")
    public List<AvgEndForce> searchAvgEndForce(SearchDataForVisual dto)
    {
        return this.avgEndForceSearch.returnAvgEndForce(dto);
    }
}
