package kg.megacom.orderservice.controllers;

import kg.megacom.orderservice.models.dto.OrderDto;
import kg.megacom.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/create")
    public OrderDto createOrder(@RequestBody OrderDto orderDto){

        return orderService.createOrder(orderDto);
    }
    @GetMapping("/all")
    public List<OrderDto> findAll(){
        return null;
    }
}
