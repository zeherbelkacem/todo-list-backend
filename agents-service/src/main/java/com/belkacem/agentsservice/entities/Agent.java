package com.belkacem.agentsservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agents")
public class Agent implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "OS")
    private String os;

    @Column(name = "LAST_KEEP_ALIVE")
    private Date lastKeepAlive;

    @Column(name = "DATE_ADD")
    private Date dateAdd;

    @Column(name = "IP_ADDRESS")
    private String ip;

    @Column(name = "NAME")
    private String name;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "STATUS")
    private String status;

}
