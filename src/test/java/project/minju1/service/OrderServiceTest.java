package project.minju1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import project.minju1.entity.Item;
import project.minju1.entity.Member;
import project.minju1.entity.Order;
import project.minju1.entity.OrderItem;
import project.minju1.repository.ItemRepository;
import project.minju1.repository.MemberRepository;
import project.minju1.repository.OrderRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Commit
class OrderServiceTest {

    @Autowired MemberService memberService;
    @Autowired ItemService itemService;
    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;

    @BeforeEach
    public void before(){
        Member memberA = new Member("memberA");
        memberService.join(memberA);

        Item itemA = new Item("item1",1000,10);
        itemService.itemSave(itemA);

        Order order = orderService.orderCreate(memberA.getId(), itemA.getId(), 2);


    }

    @Test
    public void findByMemberIdTest(){
        Long memberId = memberService.findByUsername("memberA").get(0).getId();
        Order findByMemberId = orderRepository.findByMemberId(memberId).get(0);
        System.out.println("findByMemberIdResult = " + findByMemberId);
        System.out.println("result.order = " + findByMemberId.getOrderItems().get(0).getItem().getName());

    }


    @Test
    public void orderTest(){

    }
}