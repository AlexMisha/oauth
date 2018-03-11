package com.shepard.oauth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "manager_password")
public class ManagerPassword {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id")
    @SequenceGenerator(name = "sq_id", sequenceName = "sq_manager_password", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    @OneToOne(targetEntity = Manager.class, cascade = CascadeType.ALL)
    private Manager manager;

    @Getter
    @Setter
    @Column(name = "hash")
    private String hash;

}
