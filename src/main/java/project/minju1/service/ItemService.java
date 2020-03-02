package project.minju1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.minju1.entity.Item;
import project.minju1.repository.ItemRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    /**
     * item 생성
     */
    public Long itemSave(Item item){
        itemRepository.save(item);
        return item.getId();
    }

    /**
     * item 삭제
     */
    public void itemDelete(Long itemId){
        Item findItem = itemRepository.findById(itemId).get();
        itemRepository.delete(findItem);
    }

    /**
     * item 수정
     */

    /**
     *item 이름으로 조회
     */
    public List<Item> findByName(String name){
        List<Item> result = itemRepository.findByName(name);
        return result;
    }
}
