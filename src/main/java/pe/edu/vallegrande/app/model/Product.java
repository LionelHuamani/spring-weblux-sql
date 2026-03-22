package pe.edu.vallegrande.app.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "product")
public class Product {

    @Id
    @Column("id")
    private Integer id;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @Column("price")
    private Double price;

    @Column("quantity")
    private Integer quantity;
}