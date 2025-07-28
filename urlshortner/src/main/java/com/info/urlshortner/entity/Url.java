package com.info.urlshortner.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;// primary key of table
    @Column(nullable = false)
    private String original; //user set this url
    private String shorturl;
    private LocalDateTime currnetdate;
    private LocalDateTime expiredate;
}

