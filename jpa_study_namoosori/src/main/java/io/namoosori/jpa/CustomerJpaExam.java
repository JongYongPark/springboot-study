package io.namoosori.jpa;

import io.namoosori.jpa.entity.*;
import jakarta.persistence.*;

import java.util.List;

public class CustomerJpaExam {
    public void insert_customer1(){
        // presistence.xml 의  persistence-unit 의 이름과 동일해야 한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(Customer.sample());

        tx.commit();
        em.close();
        emf.close();
    }

    public void update_customer1(){
        // presistence.xml 의  persistence-unit 의 이름과 동일해야 한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        System.out.println("=> Call em.persist");
        // insert
        em.persist(Customer.sample());

        System.out.println("=> Call em.find");
        // update
        Customer foundCustomer = em.find(Customer.class, 1);
        foundCustomer.setName("Ryan");

        System.out.println("=> Call tx.commit");
        tx.commit();

        em.close();
        emf.close();
    }

    public void remove_customer1(){
        // presistence.xml 의  persistence-unit 의 이름과 동일해야 한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        System.out.println("=> Call em.persist");
        em.persist(Customer.sample());

        System.out.println("=> Call em.find");
        Customer foundCustomer = em.find(Customer.class, 1);
        foundCustomer.setName("Ryan");

        System.out.println("=> Call remove");
        em.remove(foundCustomer);

        System.out.println("=> Call tx.commit");
        tx.commit();

        em.close();
        emf.close();
    }

    public void no_persist_and_find(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Customer customer = Customer.sample();
        em.persist(customer);
        tx.commit();
        em.detach(customer);
        System.out.println("=========================");

        tx.begin();
        try {
            System.out.println("=> Don't Call em.persist");
//          em.persist(Customer.sample());

            System.out.println("=> Call em.find");
            Customer foundCustomer = em.find(Customer.class, 1);
            System.out.println(foundCustomer.toString());

            System.out.println("=> Call tx.commit");
            tx.commit();

        } catch (Exception e){
            System.out.println("=> Call tx.rollback");
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    public void no_persist_and_find2(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Customer customer = Customer.sample();
        em.persist(customer);
        tx.commit();
        em.detach(customer);
        System.out.println("=========================");

        tx.begin();
        try {
            System.out.println("=> Don't Call em.persist");
//          em.persist(Customer.sample());

            System.out.println("=> Call em.find");
            Customer foundCustomer = em.find(Customer.class, 2);
            System.out.println(foundCustomer.toString());

            System.out.println("=> Call tx.commit");
            tx.commit();

        } catch (Exception e){
            System.out.println("=> Call tx.rollback");
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
    public void persist_and_find(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            Customer customer = new Customer(1L,"Kim");
            System.out.println("=> Call em.persist");
            em.persist(customer);
            System.out.println(customer.toString());

            // no select query. get data from persist
            System.out.println("=> Call em.find");
            Customer cus01 = em.find(Customer.class, 1);
            System.out.println(cus01.toString());

            // insert query
            System.out.println("=> Call tx.commit");
            tx.commit();
        } catch (Exception e){
            System.out.println("=> Call tx.rollback");
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    public void persist_and_detach_and_find(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            Customer customer = new Customer(1L,"Kim");
            System.out.println("=> Call em.persist");
            em.persist(customer);
            System.out.println(customer.toString());

            System.out.println("=> Call em.detach");
            em.detach(customer);
            // no select query. get data from persist
            System.out.println("=> Call em.find");
            Customer cus01 = em.find(Customer.class, 1);
            System.out.println(cus01.toString());

            // insert query
            System.out.println("=> Call tx.commit");
            tx.commit();
        } catch (Exception e){
            System.out.println("=> Call tx.rollback");
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
    public void persist1_and_find2(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            Customer customer = new Customer(1L,"Kim");
            System.out.println("=> Call em.persist");
            em.persist(customer);
            System.out.println(customer.toString());

            // select query. because id 2 is not in persist cache
            System.out.println("=> Call em.find");
            Customer cus01 = em.find(Customer.class, 2);
            System.out.println(cus01.toString());

            // insert query
            System.out.println("=> Call tx.commit");
            tx.commit();
        } catch (Exception e){
            System.out.println("=> Call tx.rollback");
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    public void persist1_and_find_2(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            Customer customer = new Customer(1L,"Kim");
            System.out.println("=> Call em.persist");
            em.persist(customer);
            System.out.println(customer.toString());

            // select query. because id 2 is not in persist cache
            System.out.println("=> Call em.find");
            Customer cus01 = em.find(Customer.class, 2);
            System.out.println(cus01.toString());

            // insert query
            System.out.println("=> Call tx.commit");
            tx.commit();
        } catch (Exception e){
            System.out.println("=> Call tx.rollback");
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    public void no_persist_and_find__2nd(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Customer customer = new Customer(1L,"Kim");
            System.out.println("=> Don't Call em.persist");
//            em.persist(customer);
            System.out.println(customer.toString());

            // select query. because id 1 is not in persist cache
            System.out.println("=> Call em.find");
            Customer cus01 = em.find(Customer.class, 1);
            System.out.println(cus01.toString());

            // insert query
            System.out.println("=> Call tx.commit");
            tx.commit();

        } catch (Exception e){
            System.out.println("=> Call tx.rollback");
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    public void flush_no_commit(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Customer customer = new Customer(1L,"Kim");
            Customer customer2 = new Customer(2L,"Park");
            System.out.println("=> Call em.persist");
            em.persist(customer);
            System.out.println(customer.toString());
            em.persist(customer2);
            System.out.println(customer2.toString());


            System.out.println("=> Call em.flush");
            em.flush();

            System.out.println("=> Don't Call tx.commit");
//            tx.commit();

        } catch (Exception e){
            System.out.println("=> Call tx.rollback");
            tx.rollback();
        } finally {
            System.out.println("=> Call em.close");
            em.close();
        }
        System.out.println("=> Call emf.close");
        emf.close();
    }
    public void no_flush_and_createQuery(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Customer customer = new Customer(1L,"Kim");
            Customer customer2 = new Customer(2L,"Park");
            System.out.println("=> Call em.persist");
            em.persist(customer);
            System.out.println(customer.toString());
            em.persist(customer2);
            System.out.println(customer2.toString());

            System.out.println("=> Don't Call em.flush");
//            em.flush();

            System.out.println("=> Call createQuery - internally em.flush() called");
            Query query = em.createQuery("SELECT c FROM Customer c",Customer.class);
            List<Customer> customers = query.getResultList();
            System.out.println(customers);

            System.out.println("=> Call tx.commit");
            tx.commit();

        } catch (Exception e){
            System.out.println("=> Call tx.rollback");
            tx.rollback();
        } finally {
            System.out.println("=> Call em.close");
            em.close();
        }
        System.out.println("=> Call emf.close");
        emf.close();
    }

    public void student_test(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            Major major = new Major("Computer Science","College of Engineering");
            em.persist(major);

            Student student = new Student("Kim","3");
            student.setMajor(major);
            em.persist(student);

            em.flush();
            em.clear();

            //student 검색
            // fetch = FetchType.EAGER -> join query
            // fetch = FetchType.LAZY -> select from student
            System.out.println("=> Call em.find");
            Student foundStudent = em.find(Student.class,1);

            // fetch = FetchType.LAZY -> select from major
            System.out.println("=> Call foundStudent.getMajor().getName()");
            System.out.println(foundStudent.getMajor().getName());
//            Major foundMajor = em.find(Major.class,foundStudent.getMajor());
//            System.out.println(foundStudent);

//            Major foundMajor = em.find(Major.class,foundStudent.getMajor());
//            System.out.println(foundMajor);

            System.out.println("=> Call tx.commit");
            tx.commit();
        }catch(Exception e){
            // 문제가 있었을때는 tx.rollback()
            tx.rollback();
            System.out.println("커밋실패 & 롤백 가동");
        }finally {
            em.close();
        }
        emf.close();
    }

    public void student_bad_test(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try{
            MajorBad major = new MajorBad("Computer Science","College of Engineering");
            em.persist(major);

            StudentBad student = new StudentBad("Kim","3");
            student.setMajorId(major.getMajorId());
            em.persist(student);

            em.flush();
            em.clear();

            //student 검색
            StudentBad foundStudent = em.find(StudentBad.class,1);
            System.out.println(foundStudent);

            MajorBad foundMajor = em.find(MajorBad.class,foundStudent.getMajorId());
            System.out.println(foundMajor);

            tx.commit();
        }catch(Exception e){
            // 문제가 있었을때는 tx.rollback()
            tx.rollback();
            System.out.println("커밋실패 & 롤백 가동");
        }finally {
            em.close();
        }
        emf.close();
    }
    public void login_test(){

    }
    // https://www.youtube.com/watch?v=vMdpdui4VkA&list=PLOSNUO27qFbvzGd3yWbHISxHctPRKkctO&index=8
    public static void main(String[] args) {
        CustomerJpaExam test = new CustomerJpaExam();
//        test.insert_customer1 ();
//        test.update_customer1();
//        test.remove_customer1();
//        test.no_persist_and_find();
//        test.no_persist_and_find__2nd();
//        test.no_persist_and_find2();
//        test.persist_and_find();
//        test.persist1_and_find2();
//        test.flush_no_commit();
//        test.no_flush_and_createQuery();
//        test.persist_and_detach_and_find();
//        test.student_bad_test();
        test.student_test();
//        test.login_test();

//        CustomerJpaIdGen test1 = new CustomerJpaIdGen();
//        test1.id_test();
//        test1.seq_test();
//        test1.seq_test2();
//        test1.table_test();
    }
}
