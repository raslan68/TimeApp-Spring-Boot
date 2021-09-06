package com.ramiaslan.timeapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tbl_task")
public class Task extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 25, nullable = false)
    private Status status;

    @Column(name = "time_should", nullable = false)
    private Double timeShould;

    @Column(name = "time_is")
    private Double timeIs;

    @Column(name = "delta_time")
    private Double deltaTime;

    @OneToMany(mappedBy = "task")
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            mappedBy = "tasks")
    private Set<User> users = new HashSet<>();

    public Double calculateDeltaTime(Double timeIs, Double timeShould) {
        if (timeIs == 0 || timeShould == 0) {
            return 0.;
        } else {
            return timeIs - timeShould;
        }
    }
}
