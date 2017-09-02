package com.training.SpringFudamentSrpingBoot1.dto;

import javax.persistence.Column;
import javax.persistence.Id;

//@Entity
public class EmployeeDto {
    @Id
    private Integer id;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    private String goodThing = "all thing";

    public static void main(String[] args) {


    }
}
