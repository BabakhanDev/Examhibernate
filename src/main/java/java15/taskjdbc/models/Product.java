package java15.taskjdbc.models;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
private Long id;
private String name;
private String rating;
private int price;


    public Product(String name, String rating, int price) {
        this.name = name;
        this.rating = rating;
        this.price = price;
    }
}

