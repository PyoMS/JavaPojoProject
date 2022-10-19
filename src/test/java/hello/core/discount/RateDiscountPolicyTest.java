package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10프로 할인이 적용되야 함.")
    void vip_o() {
        Member memberVip = new Member(1L, "memberVip", Grade.VIP);

        int discount = discountPolicy.discount(memberVip, 10000);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 ㄴㄴ")
    void vip_x() {
        Member memberVip = new Member(2L, "memberNon", Grade.BASIC);

        int discount = discountPolicy.discount(memberVip, 10000);
        assertThat(discount).isEqualTo(0);
    }
}