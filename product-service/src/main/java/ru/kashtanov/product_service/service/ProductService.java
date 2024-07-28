package ru.kashtanov.product_service.service;

import org.springframework.stereotype.Service;
import ru.kashtanov.product_service.dto.CoffeeRequestDto;
import ru.kashtanov.product_service.dto.ProductRequestDto;
import ru.kashtanov.product_service.model.Coffee;
import ru.kashtanov.product_service.model.Product;
import ru.kashtanov.product_service.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(CoffeeRequestDto coffeeRequestDto){
        System.out.println(coffeeRequestDto + "In SERVICE");
        productRepository.save(new Coffee(coffeeRequestDto.getProductName(), coffeeRequestDto.getSkuCode(),
                coffeeRequestDto.getQuantity(),coffeeRequestDto.getCountry()));
    }
    public List<Product> getProductsList(){
        return productRepository.findAll();
    }


    public List<Product> getProductInStockList(){
        return  productRepository.findAll().stream()
                .filter(product -> product.getQuantity()>0).toList();
    }


}
