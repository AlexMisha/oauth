package com.shepard.oauth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id")
    @SequenceGenerator(name = "sq_id", sequenceName = "sq_product", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "count")
    private Long count;
}
