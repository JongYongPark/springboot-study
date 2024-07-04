package io.namoosori.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

// use @NoArgsConstructor to create default constuctor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity//Customer는 테이블에 들어갈 entity임을 명시
@Table(name="customer2_tb")//(어느테이블에 들어갈지) 들어가게 될 테이블명 명시
@SequenceGenerator(name="customer_generator", sequenceName="customer_seq", initialValue = 1, allocationSize = 50)
public class CustomerSeq {

    @Id //pk임을 알려줌
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")

    // 이미 sequence generator 가 db_seq라는 이름으로 있고 이를 사용하는 경우
    // 이때 hibernate.hbm2ddl.auto가 create 와 같은 것으로 설정되면 안된다. update같은 걸 사용해야.

//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
//    @SequenceGenerator(name="my_seq", sequenceName = "db_seq");

//    @Column(name = "user_id",nullable = false,length = 1)
    private Long id;
    private String name;
    //@Column 어노테이션 없으면 해당필드는 기본적으로 @Basic어노테이션임
    private long registerDate;

    //디폴트 생성자가 없는 상태
    //그래서 entitymanager가 객체를 생성할 수 없는 상태
//    @Builder // 이게 있어야 select시 담아올 자료형으로 쓸수있음
    public CustomerSeq(Long id, String name){
        this.id=id;
        this.name =name;
        this.registerDate=System.currentTimeMillis();
    }

    public static CustomerSeq sample(){
        return new CustomerSeq(1L,"Kim");
    }

//    public Customer sample(){
//        return new Customer(1L,"Kim");
//    }

}
