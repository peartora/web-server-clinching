package com.example.webserverclinching.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name="clinching_cp")
@Getter
public class ClinchingCp {

    @Id
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dmc_id")
    private ClinchingDmc dmc;

    private String cp;

    @Column(name="curve_result")
    private boolean curveResult;

    @Column(name="end_position_value")
    private float endPositionValue;

    @Column(name="end_force_value")
    private float endForceValue;

    @Column(name="gradient_result")
    private boolean gradientResult;

    @Column(name="created_at")
    private LocalDateTime createdAt;
}
