package io.namoosori.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
@ToString
@Entity
@Table(name = "major_tb")
public class Major {
    // majorId -> majorid on database table
    @Id
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long majorId;
    private String name;
    private String category;

    @OneToMany(mappedBy = "major")
    private List<Student> students;

    public Major(){
        this.students = new ArrayList<>();
    }

    public Major(String name,String category){
        this.name = name;
        this.category = category;
    }
}
