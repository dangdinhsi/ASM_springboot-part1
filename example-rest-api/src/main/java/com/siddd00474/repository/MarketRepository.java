package com.siddd00474.repository;

import com.siddd00474.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MarketRepository extends JpaRepository<Market,String> {
    List<Market> findAllByStatus(int status);
}
