package io.namoosori.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="student_tb")
public class Student {
    @Id
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String name;
    private String grade;
//    private Long majorId;

    // major_id is column of major table
//    @ManyToOne(fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "majorid")
    private Major major;

    public Student(String name,String grade){
        this.name = name;
        this.grade = grade;
    }
}
