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
    private final MarketRepository marketRepository;

    @Autowired
    public MarketController (MarketRepository marketRepository){
        this.marketRepository = marketRepository;
    }

    @GetMapping("/all")
    public List<Market> getAllMarkets(){
        return marketRepository.findAll();
    }

    @PostMapping
    public Market saveMarket(@RequestBody Market market){
        return this.marketRepository.save(market);
    }

    @DeleteMapping("/{id}")
    public Optional<Market> deleteMarket(@PathVariable("id") String id){
        Optional<Market> optionalMarket = this.marketRepository.findById(id);
        optionalMarket.ifPresent(market -> this.marketRepository.delete(market));
        return optionalMarket;
    }

    @GetMapping("/street/{street}")
    public List<Market> findAllMarketsByAddressStreet(@PathVariable("street") String street){
        return this.marketRepository.findAllByAddressStreet(street);
    }

    @GetMapping("/name/{name}")
    public List<Market> findAllMarketsByName(@PathVariable("name") String name){
        return this.marketRepository.findAllByName(name);
    }

    @GetMapping("/product/{prodName}/{maxPrice}")
    public List<Market> findAllMarketsByProductsNameAndProductPriceLessThan(@PathVariable("prodName") String prodName, @PathVariable("maxPrice") double maxPrice){
        return this.marketRepository.findAllByProduct_NameAndPriceLessThan(prodName, maxPrice);
    }
}
