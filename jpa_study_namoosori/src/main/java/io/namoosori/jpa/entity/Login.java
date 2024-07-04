package io.namoosori.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Entity
public class Login {

    @Id
    private String userId;
    private String password;
    private String userName;
    private String userRole;
    @CreationTimestamp
    private Timestamp regDt;
}
