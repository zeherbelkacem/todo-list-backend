package com.belkacem.todolistservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TITLE")
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="state_id", nullable=false)
    private RelatedState relatedState;

    @Column(name = "STATUS")
    private boolean status;

    @Column(name = "DESCRIPTION")
    private String description;
}
