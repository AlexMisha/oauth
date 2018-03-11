package com.shepard.oauth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id")
    @SequenceGenerator(name = "sq_id", sequenceName = "sq_manager", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "login")
    private String login;
}
