package ru.kashtanov.order_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.kashtanov.order_service.dto.OrderRequestDto;
import ru.kashtanov.order_service.model.Order;
import ru.kashtanov.order_service.model.Product;
import ru.kashtanov.order_service.repository.OrderRepository;

import java.util.ArrayList;
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

//    List<Product> products = new ArrayList<>(); /////////////////////////////////////////////////___WORKING_SNIPPET
//    Coffee[] coffees = webClientBuilder.build().get() // get() starts build *get http request*
//            .uri("http://localhost:8087/api/v1/product_scope/coffee_in_stock",
//                    UriBuilder::build)
//            .retrieve()
//            .bodyToMono(Coffee[].class).block();



    public void placeOrder(OrderRequestDto orderRequestDto) {
        System.out.println(orderRequestDto.getProductListList().get(0).getId() +" : ID HERE");
        List<String>skuCodes = new ArrayList<>();
        List<Product>products = new ArrayList<>();
        orderRequestDto.getProductListList().forEach(product -> skuCodes.add(product.getSkuCode()));
        System.out.println(skuCodes + "_________here");

        Product[] coffees = webClientBuilder.build().get() // get() starts build *get http request*
                .uri("http://localhost:8087/api/v1/product_scope/coffee_in_stock",
                        uriBuilder -> uriBuilder.queryParam("skuCodes",skuCodes).build())
                .retrieve()
                .bodyToMono(Product[].class).block();
        for(Product product:coffees){

            System.out.println(product + "___in order service ___ID__=" + product.getId());
        }

        if (coffees != null) {
            try {
                products.addAll(List.of(coffees));
            } catch (NullPointerException e) {
                throw new RuntimeException();
            }
        }
        System.out.println(products +": PRODUCTS LIST");



        orderRepository.save(new Order(orderRequestDto.getOrderNumber()
                ,orderRequestDto.getOwnerName(),products));
    }

    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }
}
