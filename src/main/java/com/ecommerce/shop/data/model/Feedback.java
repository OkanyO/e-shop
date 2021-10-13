package com.ecommerce.shop.data.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
    private String rating;
}
