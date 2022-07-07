package com.d3stroya.restdatajpa2.repository;

import com.d3stroya.restdatajpa2.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
