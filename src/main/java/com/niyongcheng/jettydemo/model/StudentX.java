package com.niyongcheng.jettydemo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentX {

    private String name;
    private String weight;
    private int age;
}
