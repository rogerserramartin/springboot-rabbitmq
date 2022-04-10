package com.rogerserra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

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
