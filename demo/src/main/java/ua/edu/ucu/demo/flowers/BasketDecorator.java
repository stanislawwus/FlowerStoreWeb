package ua.edu.ucu.demo.flowers;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BasketDecorator extends ItemDecorator {

    private Item item;

    @Override
    public String getDescription() {
        return item.getDescription();
    }

    public double getPrice(){
        return 4 + item.price();
    }

}