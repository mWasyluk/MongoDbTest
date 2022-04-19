package pl.mvasio.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.mvasio.mongodb.model.Address;
import pl.mvasio.mongodb.model.Market;
import pl.mvasio.mongodb.model.Product;
import pl.mvasio.mongodb.repository.MarketRepository;

import java.util.Arrays;

@Component
public class DbSeeder implements CommandLineRunner {

    private MarketRepository marketRepository;

    @Autowired
    public DbSeeder (MarketRepository marketRepository){
        this.marketRepository = marketRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Market biedronka = new Market(
                "Biedronka",
                new Address(
                        "Puławska",
                        134,
                        "Warszawa" ),
                7,
                Arrays.asList(
                        new Product("Masło roślinne", 8.99, 55),
                        new Product("Wędlina Krakus", 7.69, 32),
                        new Product("Piersi z kurczaka", 11.19, 21))
        );
        Market carrefour = new Market(
                "Carrefour",
                new Address(
                        "Puławska",
                        103,
                        "Warszawa" ),
                6,
                Arrays.asList(
                        new Product("Kawa zbożowa", 11.99, 28),
                        new Product("Mleko sojowe", 4.39, 17))
        );
        Market lidl = new Market(
                "Lidl",
                new Address(
                        "Złota",
                        18,
                        "Kraków" ),
                7,
                Arrays.asList(
                        new Product("Kasza gryczana", 3.59, 45),
                        new Product("Jabłka polskie", 2.64, 89))
        );

        this.marketRepository.deleteAll();

        this.marketRepository.saveAll(Arrays.asList(biedronka, lidl, carrefour));

    }
}
