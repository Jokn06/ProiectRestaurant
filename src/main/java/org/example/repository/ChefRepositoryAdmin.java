package org.example.repository;

import org.example.entity.Chef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefRepositoryAdmin extends JpaRepository<Chef, Integer> {
}
