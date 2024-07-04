# shortcut
https://stackoverflow.com/questions/38992114/system-out-println-shortcut-on-intellij-idea


# H2 database 시작
C:\Program Files (x86)\H2\bin\h2w.bat 

@start javaw -cp "h2-2.2.224.jar;%H2DRIVERS%;%CLASSPATH%" org.h2.tools.Console %*
@if errorlevel 1 pause


http://10.129.67.36:8082/login.jsp?jsessionid=448f572174286e890ef3f40ca31a2bf4



// https://velog.io/@think2wice/Hibernate-hbm2ddl.auto-%ED%94%84%EB%A1%9C%ED%8D%BC%ED%8B%B0-%EC%84%A4%EC%A0%95

//    create : SessionFactory 시작시 스키마를 삭제하고 다시 생성
//    create-drop : SessionFactory 종료시 스키마를 삭제
//    update : SessionFactory 시작시 객체 구성와 스키마를 비교하여 컬럼 추가/삭제 작업을 진행함. 기존의 스키마를 삭제하지 않고 유지.
//    validate : SessionFactory 시작시 객체구성과 스키마가 다르다면 예외 발생시킴.




jpa-for-beginner/chap-01/pom
/customer_ddl.sql

CREATE TABLE customer_tb (
id VARCHAR(255) NOT NULL,
name VARCHAR(255) NOT NULL,
registerDate BIGINT NOT NULL,
PRIMARY KEY(id)
);

# persist
persist cache에 넣는다.
# update
Setter를 통해 설정하면 persist 안에서 값이 변경되고
실제 commit시 반영된다.
# find
presist 안에 없는 객체에 대해서는 실제 select query를 통해 얻어온다.
안에 있으면 persist에서 바로 읽어온다. 따라서 select query가 나가지 않는다.
# flush 
다음 3가지 환경에서 em.flush가 호출된다. 즉 SQL query 가 날라간다. 
그러나 tx.commit으로 실제 commit 되지 않느면 database에 반영되지 않는다.
1. em.flush
2. em.createQuery
3. tx.commit

# id

CREATE TABLE customer1_tb (
id VARCHAR(255) NOT NULL,
name VARCHAR(255) NOT NULL,
registerDate BIGINT NOT NULL,
PRIMARY KEY(id)
);

persist 호출시 id를 지정하는 insert query가 나간다.
이는 commit 이전에 발생한다.

# seq

CREATE TABLE customer2_tb (
id VARCHAR(255) NOT NULL,
name VARCHAR(255) NOT NULL,
registerDate BIGINT NOT NULL,
PRIMARY KEY(id)
);

allocationSize = 1를 하면 presist 호출마다 다음 sequence를 물어본다.
50으로 설정 후
sequnece를 지우고
    drop sequence customer_seq;
다시 실행

seq 번호를 물어보는 횟수가 확 줄어든다. 50번까지 한꺼번에 가져오기 때문에.

이미 만들어져 있는 seq를 사용하는 경우 

이미 sequence generator 가 db_seq라는 이름으로 있고 이를 사용하는 경우
이때 hibernate.hbm2ddl.auto가 create 와 같은 것으로 설정되면 안된다. update같은 걸 사용해야.

@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
@SequenceGenerator(name="my_seq", sequenceName = "db_seq");

# table
CREATE TABLE customer3_tb (
id VARCHAR(255) NOT NULL,
name VARCHAR(255) NOT NULL,
registerDate BIGINT NOT NULL,
PRIMARY KEY(id)
);

# table 자동 생성
https://allmana.tistory.com/179

pom.xml에는

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
application.yml 에 jpa 를 설정을 추가해준다.

jpa:
show-sql: true
hibernate:
ddl-auto: create


추가로

      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
이걸 추가하면 camelCase 로 컬럼명이 생성된다.

# student & major 
drop table student_tb;

CREATE TABLE student_tb (
student_id LONG NOT NULL,
name VARCHAR(255) ,
grade VARCHAR(255) ,
major_id LONG,
PRIMARY KEY(student_id)
);

drop table major_tb;

CREATE TABLE major_tb (
major_id LONG NOT NULL,
name VARCHAR(255),
category VARCHAR(255) ,
PRIMARY KEY(major_id)
);

    private Long majorId;
    private String name;
    private String category;

@Table(name="STUDENT_TB")
public class Student {
    @Id
    @GeneratedValue
    private Long studentId;
    private String name;
    private String grade;
//    private Long majorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "majorid")
    private Major major;

    public Student(String name,String grade){
        this.name = name;
        this.grade = grade;
    }
}


@Table(name = "MAJOR_TB")
public class Major {
    @Id @GeneratedValue
    private Long majorId;
    private String name;
    private String category;

    private List<Student> students;

    public Major(String name,String category){
        this.name = name;
        this.category = category;
    }
}