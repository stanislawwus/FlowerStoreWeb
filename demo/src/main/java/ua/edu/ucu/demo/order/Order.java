
package ua.edu.ucu.demo.order;

import lombok.AllArgsConstructor;
import ua.edu.ucu.demo.delivery.Delivery;
import ua.edu.ucu.demo.flowers.Item;
import ua.edu.ucu.demo.payment.Payment;

import java.util.LinkedList;

@AllArgsConstructor
public class Order {

    private LinkedList<Item> items;
    private Payment payment;
    private Delivery delivery;

    public Order() {
    }

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }
    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }
    public float calculateTotalPrice(){
        float res = 0;
        for(Item it: items){
            res += it.price();
        }
        return res;
    }
    public void addItem(Item item){
        items.add(item);
    }
    public void removeItem(Item item){
        items.remove(item);
    }
    public String processOrder(){
        float price = calculateTotalPrice();
        String paymnt = ((payment==null)? "null":payment.toString());
        String delivr = ((delivery==null)? "null":delivery.toString());
        return "YourOrder : " + "items : " + items.toString()
         + ", paymentStrategy : " + paymnt
                + ", deliveryStrategy : " + delivr
                + ", totalPrice : " + price;
    }

}
