package com.viniciusgs.mygame.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="game")
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name_game;

    private Date acquisition_date;
    private Double buy_price;
    private String media_type;

    @ManyToOne
    private Platform platform;
    @ManyToOne
    private Category category;

    private String sold;
    private String borrowed;
    private String observation;
}
