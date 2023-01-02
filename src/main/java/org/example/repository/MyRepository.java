package org.example.repository;

import lombok.RequiredArgsConstructor;
import org.example.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyRepository {

    private final EntityManager entityManager;

    public List<Product> findByProductName(String name) {
       return entityManager.createQuery("select t from Product t where t.productName=:name", Product.class)
               .setParameter("name", name)
               .getResultList();
    }

}
