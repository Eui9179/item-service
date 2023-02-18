package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ItemRepositoryTest {

    ItemRepository itemRepository =  new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Item savedItem = new Item("itemA", 10000, 10);

        //when
        itemRepository.save(savedItem);

        //then
        Item findItem = itemRepository.findById(savedItem.getId());
        Assertions.assertThat(findItem).isEqualTo(savedItem);
    }


    @Test
    void findAll() {
        //given
        Item item1 = new Item("item1", 1000, 10);
        Item item2 = new Item("item2", 2000, 20);
        Item item3 = new Item("item3", 3000, 30);

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);

        //when
        List<Item> findAllItem = itemRepository.findAll();

        //then
        Assertions.assertThat(findAllItem.size()).isEqualTo(3);
        Assertions.assertThat(findAllItem).contains(item1, item2, item3);
    }

    @Test
    void update() {
        //given
        Item item = new Item("item", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        //when
        Item updateItem = new Item("updateItem", 10000, 9);
        itemRepository.update(itemId, updateItem);

        //then
        Item findItem = itemRepository.findById(itemId);
        Assertions.assertThat(findItem.getItemName()).isEqualTo(updateItem.getItemName());
        Assertions.assertThat(findItem.getPrice()).isEqualTo(updateItem.getPrice());
        Assertions.assertThat(findItem.getQuantity()).isEqualTo(updateItem.getQuantity());
    }
}
