package com.anoystick.entity.user;

import com.anoystick.entity.feed.FeedEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Data
@Entity
@Table(name = "users")
@DynamicInsert
@DynamicUpdate
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255) comment 'user name'", nullable = false)
    private String userName;

    @Column(columnDefinition = "varchar(255) comment 'user email'", nullable = false, unique = true)
    private String userEmail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private List<FeedEntity> feedList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cccd_id")
    private CCCDEntity cccd;
}
