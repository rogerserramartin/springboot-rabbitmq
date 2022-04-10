package com.rogerserra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document // this class will be a collection and will store documents inside
public class Statistics {
    @Id
    private String id; // we can't have a document without an ID
    private Double mean;
    private Double median;
    private Double mode; //  value that appears most often in a set of data values.
    private Double standardDeviation; // measure of the amount of variation or dispersion of a set of values.
    private ArrayList<Double> quartiles;
    private Double minimumValue;
    private Double maximumValue;
    private LocalDateTime timeStamp;
}
