package project.minju1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.minju1.entity.Item;
import project.minju1.entity.Member;
import project.minju1.entity.Order;
import project.minju1.entity.OrderItem;
import project.minju1.repository.ItemRepository;
import project.minju1.repository.MemberRepository;
import project.minju1.repository.OrderRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {


    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    /**
     * 주문 생성
     */
    public Order orderCreate(Long memberId, Long itemId, int count){

        //회원 조회
        Member member = memberRepository.findById(memberId).get();
        //아이템 조회
        Item item = itemRepository.findById(itemId).get();

        //orderItem 생성
        OrderItem orderItem = OrderItem.orderItemCreate(item, item.getPrice(), count);

        //Order 생성
        Order order = Order.orderCreate(member, orderItem);

        //주문 저장
        orderRepository.save(order);
        return order;
    }

    /**
     * 주문 memberID로 조회
     */
}
