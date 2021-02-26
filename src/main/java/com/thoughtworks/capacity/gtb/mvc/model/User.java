package com.thoughtworks.capacity.gtb.mvc.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter@Setter
    private String username;

    @Getter@Setter
    private String password;

    @Getter@Setter
    private String email;
}
