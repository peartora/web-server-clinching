package com.example.webserverclinching.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name="clinching_avg_end_force")
@Getter
public class AvgEndForce {

    @Id
    private Long id;

    @Column(name="clinching_type")
    private String clinchingType;

    private LocalDateTime mfd;

    private String cp;

    @Column(name="average_end_force_value")
    private float averageEndForceValue;

    @Column(name="created_at")
    private LocalDateTime createdAt;
}
