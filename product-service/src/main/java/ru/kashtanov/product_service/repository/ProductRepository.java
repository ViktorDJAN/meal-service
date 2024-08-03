package ru.kashtanov.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kashtanov.product_service.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT i FROM Product i WHERE i.skuCode = ?1")
    List<Product> findBySkuCode(String skuCode);

}
