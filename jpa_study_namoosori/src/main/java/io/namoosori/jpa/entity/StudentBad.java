package io.namoosori.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="student_bad_tb")
public class StudentBad {
    @Id
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String name;
    private String grade;
    private Long majorId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "major_id")
//    private Major major;

    public StudentBad(String name, String grade){
        this.name = name;
        this.grade = grade;
    }
}
