package com.cydeo.repository;

import com.cydeo.entity.Address;
import com.cydeo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    //Write a derived query to get category by name

    Optional<Category> findByName(String name);
    //Write a derived query to get top 3 categories order by name desc

    List<Category> findTop3ByOrderByName();


}
