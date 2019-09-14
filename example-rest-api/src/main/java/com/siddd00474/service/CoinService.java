package com.siddd00474.service;

import com.siddd00474.entity.Coin;
import com.siddd00474.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class CoinService {
    @Autowired
    private CoinRepository coinRepository;

    //list coin
    public List<Coin> getList(){
        return coinRepository.findAllByStatus(1);
    }
    //add new coin

    public Coin addCoin(Coin coin){
        coin.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        coin.setStatus(1);
        coinRepository.save(coin);
        return coin;
    }
    //search coin by name
    public List<Coin> getCoinByName(String name){
        return coinRepository.findAllByNameAndStatus(name,1);
    }
    //search coin by marketId
    public List<Coin> getCoinByMarketID(String marketId){
        return coinRepository.findAllByMarketIdAndStatus(marketId,1);
    }
}
