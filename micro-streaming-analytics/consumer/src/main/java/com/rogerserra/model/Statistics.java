package com.rogerserra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@Document // this class will be a collection and will store documents inside
public class Statistics {
    @Id
    private String id; // we can't have a document without an ID
    private BigDecimal average;
    private BigDecimal median;
    private BigDecimal mode; //  value that appears most often in a set of data values.
    private BigDecimal standardDeviation; // measure of the amount of variation or dispersion of a set of values.
    private ArrayList<BigDecimal> quartiles;
    private BigDecimal minimumValue;
    private BigDecimal maximumValue;
    private LocalDateTime timeStamp;
}
