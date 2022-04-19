package pl.mvasio.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.mvasio.mongodb.model.Market;

@Repository
public interface MarketRepository extends MongoRepository<Market, String> {

}
