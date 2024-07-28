package ru.kashtanov.order_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import ru.kashtanov.order_service.dto.OrderRequestDto;
import ru.kashtanov.order_service.dto.ProductResponseDto;
import ru.kashtanov.order_service.model.Coffee;
import ru.kashtanov.order_service.model.Order;
import ru.kashtanov.order_service.model.Product;
import ru.kashtanov.order_service.repository.OrderRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    private static String orderNumberCounter = "ORD-";
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    public OrderService(OrderRepository orderRepository, WebClient.Builder webClientBuilder) {
        this.orderRepository = orderRepository;
        this.webClientBuilder = webClientBuilder;
    }

//    public void placeOrder(OrderRequestDto orderRequestDto){
//        ProductResponseDto[] productResponses = new ProductResponseDto[]{webClientBuilder.build().get() // get() starts build *get http request*
//                .uri("http://localhost:8087/api/v1/product_scope/coffee_in_stock")
//                .retrieve()
//                .bodyToMono(ProductResponseDto.class).block()};
//
//        List<ProductResponseDto> list = Arrays.stream(productResponses)
//                .filter(productResponseDto -> productResponseDto
//                        .getProductName().equals(orderRequestDto.getOwnerName())).toList();
//        ArrayList<Product>productArrayList = new ArrayList<>();
//
//        for (ProductResponseDto pr : list) {
//            productArrayList.add(new Product(pr.getProductName(), pr.getSkuCode(), pr.getQuantity()));
//        }
//        if(!list.isEmpty()){
//            orderNumberCounter = orderNumberCounter + list.get(0).getSkuCode();
//        }
//        System.out.println(productArrayList.get(0) + "1_element");
//        orderRepository.save(new Order(orderNumberCounter,"MR_SPIDER",productArrayList));

        public void placeOrder(){
          Coffee[] coffees =  webClientBuilder.build().get() // get() starts build *get http request*
                  .uri("http://roduct-service/api/v1/product_scope/coffee_in_stock",
                          UriBuilder::build)
                  .retrieve()
                  .bodyToMono(Coffee[].class).block();

            for(Coffee coffee:coffees){
                System.out.println(coffee);
            }





//        orderRepository.save(new Order(orderRequestDto.getOrderNumber()
//                ,orderRequestDto.getOwnerName(),orderRequestDto.getProductListList()));
    }
    public List<Order> getOrderList(){
        return orderRepository.findAll();
    }
}
