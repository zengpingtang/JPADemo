package com.xxx.jpa.test;

import com.xxx.jpa.model.Customer;

import javax.persistence.*;

public class Main {

    public static void main(String[] args) {
        //创建EntitymanagerFactory
        String presistenceUnitName = "jpa-hello";
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(presistenceUnitName);
        //创建EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //开启事务
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        //进行持久化操作
        Customer customer = new Customer();
        customer.setAge(28);
        customer.setEmail("919101974@qq.com");
        customer.setLastName("唐增平");

        entityManager.persist(customer);
        //提交事务
        entityTransaction.commit();
        //关闭entitymanager
        entityManager.close();
        //关闭entitymanagerFactory
        entityManagerFactory.close();
    }
}
