package pe.edu.vallegrande.app.service.impl;

import pe.edu.vallegrande.app.model.Product;
import pe.edu.vallegrande.app.repository.ProductRepository;
import pe.edu.vallegrande.app.service.ProductService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> findAll() {
        log.info("Mostrando productos");
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> findById(Integer id) {
        log.info("Mostrando producto por ID");
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> save(Product product) {
        log.info("Guardando producto");
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> update(Product product) {
        log.info("Actualizando producto");
        return productRepository.findById(product.getId())
                .flatMap(existing -> {
                    existing.setName(product.getName());
                    existing.setDescription(product.getDescription());
                    existing.setPrice(product.getPrice());
                    existing.setQuantity(product.getQuantity());
                    return productRepository.save(existing);
                });
    }
}