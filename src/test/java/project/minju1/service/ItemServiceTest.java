package project.minju1.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import project.minju1.entity.Item;
import project.minju1.repository.ItemRepository;

import javax.persistence.Column;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @BeforeEach
    public void before(){
        Item itemA = new Item("a",1000,10);
        Item itemB = new Item("b",1000,10);
        itemService.itemSave(itemA);
        itemService.itemSave(itemB);
    }

    @Test
    public void itemTest(){
        Item item = itemRepository.findByName("a").get(0);
        itemRepository.delete(item);
        List<Item> result = itemRepository.findAll();
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void findByNameTest(){
        Item findItem = itemService.findByName("a").get(0);
        System.out.println("findItem = " + findItem);
    }

}