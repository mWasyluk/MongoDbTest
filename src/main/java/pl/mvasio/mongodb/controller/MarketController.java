package pl.mvasio.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mvasio.mongodb.model.Market;
import pl.mvasio.mongodb.repository.MarketRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/markets")
public class MarketController {
    private MarketRepository marketRepository;

    @Autowired
    public MarketController (MarketRepository marketRepository){
        this.marketRepository = marketRepository;
    }

    @GetMapping("/all")
    public List<Market> getAllMarkets(){
        return marketRepository.findAll();
    }

    @PostMapping
    public Market save(@RequestBody Market market){
        return this.marketRepository.save(market);
    }

    @DeleteMapping("/{id}")
    public Optional<Market> delete(@PathVariable("id") String id){
        Optional<Market> optionalMarket = this.marketRepository.findById(id);
        optionalMarket.ifPresent(market -> this.marketRepository.delete(market));
        return optionalMarket;
    }
}
