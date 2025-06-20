package spring.core_basic.order;

/**
 * @author rua
 */
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
