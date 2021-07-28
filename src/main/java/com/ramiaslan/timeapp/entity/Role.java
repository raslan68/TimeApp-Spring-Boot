package com.ramiaslan.timeapp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tbl_role")
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();

}
