package ru.kashtanov.order_service.controller;



import org.springframework.web.bind.annotation.*;
import ru.kashtanov.order_service.dto.OrderRequestDto;
import ru.kashtanov.order_service.model.Coffee;
import ru.kashtanov.order_service.model.Order;
import ru.kashtanov.order_service.model.Product;
import ru.kashtanov.order_service.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order_scope")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/getProductsFromService")
    public String placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        orderService.placeOrder(orderRequestDto);
        return "Order is successfully placed";
    }

//        @PostMapping("/create_order")
//    public String placeOrder(@RequestParam String coffeeName){
//            System.out.println(coffeeName);
//        orderService.placeOrder(coffeeName);
//        return "Order is successfully placed";
//    }


    @GetMapping("/get_dto")
    public OrderRequestDto getOrderRequestDtoSample(){
        List<Product> list = new ArrayList<>();
        Product product1 = new Coffee("Coffee","Cof22",5,"Egypt"); // no Id is specified here be careful
        list.add(product1);
        OrderRequestDto orderRequestDto = new OrderRequestDto("COFF_2",list,"Smith");
        System.out.println(orderRequestDto.getOrderNumber());
        return orderRequestDto;
    }

    @GetMapping("/str")
    public String getStr(){
        return "HELLO";
    }

    @GetMapping("/whole_orders_list")
    public List<Order> getAllOrders(){
        return orderService.getOrderList();
    }
}
