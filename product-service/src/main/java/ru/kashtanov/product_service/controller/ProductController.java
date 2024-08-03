package ru.kashtanov.product_service.controller;

import org.springframework.web.bind.annotation.*;
import ru.kashtanov.product_service.dto.CoffeeRequestDto;
import ru.kashtanov.product_service.dto.ProductRequestDto;
import ru.kashtanov.product_service.model.Product;
import ru.kashtanov.product_service.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product_scope")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/singleDto")
    public ProductRequestDto getSingleDto(){
        return  new CoffeeRequestDto("Arabica","CA_2",4,"Algeria");
    }

    @PostMapping("/create")
    public String createProduct(@RequestBody CoffeeRequestDto requestDto){
        productService.createProduct(requestDto);
        return "Product successfully created";
    }
    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getProductsList();
    }

    @GetMapping("/coffee_in_stock")
    public List<Product>getCoffeeInStock(@RequestParam List<String> skuCodes) {
        return productService.getProductInStockList(skuCodes);
    }
}
