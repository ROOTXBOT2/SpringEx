package spring.core_basic.order;

import spring.core_basic.discount.DiscountPolicy;
import spring.core_basic.discount.FixDisxountPolicy;
import spring.core_basic.member.Member;
import spring.core_basic.member.MemberRepository;
import spring.core_basic.member.MemoryMemberRepository;

/**
 * @author rua
 */
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId).orElseThrow(null);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
