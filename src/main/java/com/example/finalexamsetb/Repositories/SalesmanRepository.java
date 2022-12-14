package com.example.finalexamsetb.Repositories;

import com.example.finalexamsetb.Entities.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesmanRepository extends JpaRepository<Salesman,Long> {
    List<Salesman> findSalesmanById(long key);
}
