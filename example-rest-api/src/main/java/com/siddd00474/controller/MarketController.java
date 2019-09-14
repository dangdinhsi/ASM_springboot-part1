package com.siddd00474.controller;

import com.siddd00474.entity.Market;
import com.siddd00474.service.MarketService;
import com.siddd00474.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/markets")
public class MarketController {
    @Autowired
    private MarketService marketService;

    //them market
    @PostMapping()
    public ResponseEntity<Object> addNewMarket(@RequestBody Market market){
        return new ResponseEntity<>(new JsonResponse()
                .setData(marketService.addMarket(market))
                .setMessage("save success!!")
                .setStatus(HttpStatus.CREATED.value())
                , HttpStatus.CREATED);
    }
    //list market
    @GetMapping()
    public ResponseEntity<Object> getListMarket(){
        return new ResponseEntity<>(new JsonResponse()
                .setData(marketService.getList())
                .setMessage("get list ok")
                .setStatus(HttpStatus.OK.value()),HttpStatus.OK);
    }
}
