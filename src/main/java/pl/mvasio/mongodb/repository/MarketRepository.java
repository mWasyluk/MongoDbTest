package pl.mvasio.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pl.mvasio.mongodb.model.Market;

import java.util.List;

@Repository
public interface MarketRepository extends MongoRepository<Market, String> {

    List <Market> findAllByAddressStreet(String street);
    List <Market> findAllByName (String name);
    @Query("{ products: { $elemMatch: { name: ?0, price: { $lt : ?1 } } } } ")
    List <Market> findAllByProduct_NameAndPriceLessThan(String productName, double maxPrice);
}
