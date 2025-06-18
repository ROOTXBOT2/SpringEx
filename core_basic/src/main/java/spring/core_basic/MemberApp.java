package spring.core_basic;

import spring.core_basic.member.Grade;
import spring.core_basic.member.MemberService;
import spring.core_basic.member.MemberServiceImpl;
import spring.core_basic.member.Member;
/**
 * @author rua
 */
public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member1 = new Member( Grade.VIP,"memberA");
        memberService.join(member1);

        Member findMember1 = memberService.findMember(member1.getId());
        Member findMember2 = memberService.findMember(1L);

        System.out.println("Join new member = " + member1.getName());

        System.out.println("findmember1 = " + findMember1.getName());

        System.out.println("findmember2 = " + findMember2.getName());

    }
}
