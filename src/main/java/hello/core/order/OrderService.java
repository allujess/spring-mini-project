package hello.core.order;

public interface OrderService {

    //return값이 Order
    Order createOrder(Long memberId, String itemName, int itemPrice);


}
