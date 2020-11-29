package com.example.spring_boot_introduction_spring_boot.chpater07.repositories;

import com.example.spring_boot_introduction_spring_boot.chpater07.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {
    @Query("SELECT d FROM MyData d ORDER BY d.name")
    List<MyData> findAllOrderByName();

    @Query("FROM MyData WHERE age > :min AND age < :max")
    public List<MyData> findByAge(@Param("min") int min, @Param("max") int max);
}
