package io.namoosori.jpa.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "major_bad_tb")
public class MajorBad {
    @Id
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long majorId;
    private String name;
    private String category;

//    @OneToMany(mappedBy = "major")
//    private List<Student> students;


//    public Major(){
//        this.students = new ArrayList<>();
//    }

    public MajorBad(String name, String category){
        this.name = name;
        this.category = category;
    }
}
