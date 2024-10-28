package ua.edu.ucu.demo.order;

import org.springframework.web.bind.annotation.*;
import ua.edu.ucu.demo.delivery.Delivery;
import ua.edu.ucu.demo.flowers.Flower;
import ua.edu.ucu.demo.flowers.FlowerColor;
import ua.edu.ucu.demo.flowers.Item;
import ua.edu.ucu.demo.payment.Payment;

import java.util.Arrays;
import java.util.LinkedList;

@RestController
@RequestMapping
public class OrderController {
    private Order order = new Order(new LinkedList<Item>(Arrays.asList(new Flower(21, FlowerColor.BLUE, 102), new Flower(23, FlowerColor.VIOLET, 230))),
            null, null);
    @GetMapping(path="api/v1/order/show-order")
    public String showOrder(){
        return order.processOrder();
    }
    @PostMapping(path = "api/v1/order/addItem")
    public void addItem(@RequestBody Item newItem){
        order.addItem(newItem);
    }

    @RequestMapping(value = "/api/v1/order/pay", method = RequestMethod.POST)
    public void choosePayment(@RequestBody Payment payment){
        order.setPaymentStrategy(payment);
    }

    @RequestMapping(value = "/api/v1/order/deliver", method = RequestMethod.POST)
    public void chooseDelivery(@RequestBody Delivery delivery){
        order.setDeliveryStrategy(delivery);
    }
}