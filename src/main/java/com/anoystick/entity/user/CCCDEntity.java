package com.anoystick.entity.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cccds")
public class CCCDEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberCCCD;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
