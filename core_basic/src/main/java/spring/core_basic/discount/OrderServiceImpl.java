package spring.core_basic.discount;

import spring.core_basic.member.Member;
import spring.core_basic.member.MemberRepository;
import spring.core_basic.member.MemoryMemberRepository;

/**
 * @author rua
 */
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDisxountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId).orElseThrow(null);
        int discountPrice = discountPolicy.discount(member);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
