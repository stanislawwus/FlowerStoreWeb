package ua.edu.ucu.demo.delivery;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ua.edu.ucu.demo.flowers.Item;

import java.util.List;

@JsonDeserialize(as = DHLDeliverStrategy.class)
public class DHLDeliverStrategy implements Delivery {

    @JsonProperty(value = "deliveryType")
    @SuppressWarnings("unused")
    String deliveryType;
    @Override
    public void deliver(List<Item> items) {
        System.out.println("Don't forget to receive your DHL delivery");
        System.out.println("Content of the package:");
        items.stream().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "DHLDeliverStrategy{" +
                '}';
    }
}