package project.minju1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.minju1.entity.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByName(String itemName);

}
