package io.namoosori.jpa;

import io.namoosori.jpa.entity.CustomerId;
import io.namoosori.jpa.entity.CustomerSeq;
import io.namoosori.jpa.entity.CustomerTable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerJpaIdGen {

    public void id_test(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            System.out.println("=> Create Entity CustomerId");
            CustomerId customer = new CustomerId();
            System.out.println("=> Call customer.setName");
            customer.setName("Ryan");
            System.out.println("=> Call customer.setRegisterDate");
            customer.setRegisterDate(System.currentTimeMillis());

            System.out.println("=> Call em.persist");
            em.persist(customer);
            System.out.println(customer.toString());

//            System.out.println("=> Call em.find");
//            Customer cus01 = em.find(CustomerId.class, 1);
//            System.out.println(cus01.toString());

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

    public void seq_test(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            System.out.println("=> Create Entity CustomerSeq");

            for (int i=0; i <70 ; i++) {

                CustomerSeq customer = new CustomerSeq();
//            System.out.println("=> Call customer.setName");
                customer.setName("Ryan");
//            System.out.println("=> Call customer.setRegisterDate");
                customer.setRegisterDate(System.currentTimeMillis());
//            System.out.println("=> Call em.persist");
                em.persist(customer);
//            System.out.println(customer.toString());
            }

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

    public void seq_test2(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            System.out.println("=> Create Entity CustomerSeq");

            for (int i=0; i <70 ; i++) {

                CustomerSeq customer = new CustomerSeq();
//            System.out.println("=> Call customer.setName");
                customer.setName("Ryan");
//            System.out.println("=> Call customer.setRegisterDate");
                customer.setRegisterDate(System.currentTimeMillis());
//            System.out.println("=> Call em.persist");
                em.persist(customer);
//            System.out.println(customer.toString());
            }

            System.out.println("=> Call tx.commit");
            tx.commit();
        } catch (Exception e){
            System.out.println("=> Call tx.rollback");
            tx.rollback();
        }

        System.out.println("======================");
        tx.begin();
        try {
            System.out.println("=> Create Entity CustomerSeq");

            for (int i=0; i <70 ; i++) {

                CustomerSeq customer = new CustomerSeq();
//            System.out.println("=> Call customer.setName");
                customer.setName("Ryan");
//            System.out.println("=> Call customer.setRegisterDate");
                customer.setRegisterDate(System.currentTimeMillis());
//            System.out.println("=> Call em.persist");
                em.persist(customer);
//            System.out.println(customer.toString());
            }

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

    public void table_test(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            System.out.println("=> Create Entity CustomerTable");

            CustomerTable customer = new CustomerTable();
            System.out.println("=> Call customer.setName");
            customer.setName("Ryan");
            System.out.println("=> Call customer.setRegisterDate");
            customer.setRegisterDate(System.currentTimeMillis());
            System.out.println("=> Call em.persist");
            em.persist(customer);
            System.out.println(customer.toString());

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

}
