package com.rogerserra.model;

import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OpengateResponse {
    private String id;
    private LocalDateTime timestamp;
    private String name;
    private String resultCode;
    private String resultDescription;
    private ArrayList<Machine> machines;
}
