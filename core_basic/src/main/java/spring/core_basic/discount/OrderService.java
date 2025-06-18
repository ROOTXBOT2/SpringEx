package spring.core_basic.discount;

/**
 * @author rua
 */
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
