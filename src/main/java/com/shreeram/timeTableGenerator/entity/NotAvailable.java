package com.shreeram.timeTableGenerator.entity;

import com.shreeram.timeTableGenerator.entity.enums.Period;
import jakarta.persistence.Entity;

import java.time.DayOfWeek;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotAvailable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private DayOfWeek day;
    private Period period;
    @ManyToOne
    private Teacher teacher;
}
