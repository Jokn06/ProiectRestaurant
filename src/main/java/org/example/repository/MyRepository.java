package org.example.repository;

import lombok.RequiredArgsConstructor;
import org.example.entity.Menu;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MyRepository {

    private final EntityManager entityManager;

    public List<Menu> findByProductName(String name) {
       return entityManager.createQuery("select t from Menu t where t.productName=:name", Menu.class)
               .setParameter("name", name)
               .getResultList();
    }

}
