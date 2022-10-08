package de.kessel.elena.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class PostBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected Integer id;

    @Lob
    protected String text;

    protected LocalDate createdAt;

    protected LocalDate updatedAt;

}
