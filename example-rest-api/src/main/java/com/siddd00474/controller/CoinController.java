package com.siddd00474.controller;

import com.siddd00474.entity.Coin;
import com.siddd00474.service.CoinService;
import com.siddd00474.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping(value = "/api/coins")
public class CoinController {
    @Autowired
    private CoinService coinService;

    // list
    @GetMapping()
    public ResponseEntity<Object> getListCoin(){
        return new ResponseEntity<>(new JsonResponse().setData(coinService.getList())
                .setMessage("get list coin success!!!")
                .setStatus(HttpStatus.OK.value()), HttpStatus.OK);
    }
    //add new coin
    @PostMapping()
    public ResponseEntity<Object> addNewCoin(@RequestBody Coin coin){
        return new ResponseEntity<>(new JsonResponse()
                .setData(coinService.addCoin(coin))
                .setMessage("save coin success")
                .setStatus(HttpStatus.CREATED.value()),HttpStatus.CREATED);
    }
    //search coin by name

    @RequestMapping(method = RequestMethod.GET,value = "/search/{name}")
    public ResponseEntity<Object> searchCoinByName(@PathVariable String name){
        return new ResponseEntity<>(
                new JsonResponse()
                .setData(coinService.getCoinByName(name))
                .setStatus(HttpStatus.OK.value())
                .setMessage("get coin by name success")
                ,HttpStatus.OK);
    }

    //search coin by marketId
    @RequestMapping(method = RequestMethod.GET,value ="/{marketId}")
    public ResponseEntity<Object> searchCoinByMarketID(@PathVariable String marketId){
        return new ResponseEntity<>(
                new JsonResponse()
                .setData(coinService.getCoinByMarketID(marketId))
                .setStatus(HttpStatus.OK.value())
                .setMessage("get coin by marketId success")
                ,HttpStatus.OK);
    }
}
