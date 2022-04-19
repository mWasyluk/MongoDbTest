package pl.mvasio.mongodb.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Markets")
@RequiredArgsConstructor
public class Market {
    @Id
    private String id;
    @NonNull
    private String name;
    @NonNull
    private Address address;
    @NonNull
    private int rating;
    @NonNull
    private List<Product> products;
}
