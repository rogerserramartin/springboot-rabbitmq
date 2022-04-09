package com.rogerserra.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Machine {
    private String name;
    private String result;
    //private LocalDateTime timestamp;
    private BigDecimal energyConsumption;
}
