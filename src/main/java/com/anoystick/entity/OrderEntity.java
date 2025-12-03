package com.anoystick.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@Table(name = "orders")
@DynamicInsert
@DynamicUpdate
public class OrderEntity {
    @Id
    private Long id;
}
