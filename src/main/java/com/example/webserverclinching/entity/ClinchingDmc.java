package com.example.webserverclinching.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clinching_dmc")
@NoArgsConstructor
@Getter
public class ClinchingDmc {

    @Id
    private Long id;

    private String dmc;

    @OneToMany(mappedBy = "dmc")
    private List<ClinchingCp> cps = new ArrayList<>();

    @Column(name="clinching_type")
    private String clinchingType;

    private LocalDateTime mfd;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="operation_result")
    private boolean operationResult;

    //    @Column(name="monitoring_result")
    //    private Boolean monitoringResult;

}
