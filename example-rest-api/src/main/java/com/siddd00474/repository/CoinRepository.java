package com.siddd00474.repository;

import com.siddd00474.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinRepository extends JpaRepository<Coin,Long> {
    List<Coin> findAllByStatus(int status);
    List<Coin> findAllByNameAndStatus(String name, int status);
    List<Coin> findAllByMarketIdAndStatus(String marketId, int status);
}
