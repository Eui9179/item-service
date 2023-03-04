package springboot.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @AfterEach
    public void cleanup() {
        itemRepository.deleteAll();
    }

    @Test
    void 아이템저장_불러오기() {
        //given
        String itemName = "test";
        Integer price = 1000;
        Integer quantity = 10;

        itemRepository.save(Item.builder()
                .itemName(itemName)
                .price(price)
                .quantity(quantity)
                .build());

        //when
        List<Item> itemList = itemRepository.findAll();

        //then
        Item item = itemList.get(0);
        Assertions.assertThat(item.getItemName()).isEqualTo(itemName);
        Assertions.assertThat(item.getPrice()).isEqualTo(price);
    }
}
