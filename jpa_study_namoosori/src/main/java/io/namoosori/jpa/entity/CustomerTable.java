package io.namoosori.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// use @NoArgsConstructor to create default constuctor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity//Customer는 테이블에 들어갈 entity임을 명시
@Table(name="customer3_tb")//(어느테이블에 들어갈지) 들어가게 될 테이블명 명시
@TableGenerator(
        name = "id_generator",
        table="customer_id",
        pkColumnName = "id_name",
        pkColumnValue = "customer_id",
        valueColumnName = "next_value",
        initialValue = 0,
        allocationSize = 1)
public class CustomerTable {

    @Id //pk임을 알려줌
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")

//    @Column(name = "user_id",nullable = false,length = 1)
    private Long id;
    private String name;
    //@Column 어노테이션 없으면 해당필드는 기본적으로 @Basic어노테이션임
    private long registerDate;

    //디폴트 생성자가 없는 상태
    //그래서 entitymanager가 객체를 생성할 수 없는 상태
//    @Builder // 이게 있어야 select시 담아올 자료형으로 쓸수있음
    public CustomerTable(Long id, String name){
        this.id=id;
        this.name =name;
        this.registerDate=System.currentTimeMillis();
    }

    public static CustomerTable sample(){
        return new CustomerTable(1L,"Kim");
    }


}
