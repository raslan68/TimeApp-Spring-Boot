package com.ramiaslan.timeapp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tbl_assignment")
@EqualsAndHashCode(callSuper = true)
public class Assignment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", length = 50, nullable = false)
    private String username;

    @OneToMany(mappedBy = "assignment")
    private Set<Task> tasks = new HashSet<>();

}
