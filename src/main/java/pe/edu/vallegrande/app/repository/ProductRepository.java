package pe.edu.vallegrande.app.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import pe.edu.vallegrande.app.model.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {
}