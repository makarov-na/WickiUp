package com.linnyk.jpa.certification.entities.map_extended.map_key_column;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "DEPARTMENT_MKC")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DEPARTMENT_NAME")
    @NonNull
    private String name;

    @ElementCollection
    @CollectionTable(name = "EMPLOYEE_INFO")
    @MapKeyColumn(name = "EMPLOYEE_NAME")
    @Column(name = "EMPLOYEE_SALARY")
    private Map<String, BigDecimal> employees = new HashMap<>();

}
