package com.ramiaslan.timeapp.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_comment")
@EqualsAndHashCode(callSuper = true)
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

}
