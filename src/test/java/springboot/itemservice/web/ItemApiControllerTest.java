package springboot.itemservice.web;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import springboot.itemservice.domain.item.Item;
import springboot.itemservice.domain.item.ItemRepository;
import springboot.itemservice.web.dto.ItemSaveRequestDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ItemRepository itemRepository;

    @AfterEach
    void tearDown() throws Exception {
        itemRepository.deleteAll();
    }

    @Test
    void item_등록된다() throws Exception {
        //given
        String itemName = "test1";
        Integer price = 1000;
        Integer quantity = 10;

        ItemSaveRequestDto requestDto = ItemSaveRequestDto
                .builder()
                .itemName(itemName)
                .price(price)
                .quantity(quantity)
                .build();

        String url = "http://localhost:" + port + "/api/v1/items";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Item> itemList = itemRepository.findAll();

        assertThat(itemList.get(0).getItemName()).isEqualTo(itemName);
        assertThat(itemList.get(0).getPrice()).isEqualTo(price);

    }

}
