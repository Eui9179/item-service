package springboot.itemservice.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import springboot.itemservice.domain.item.Item;

@Getter
@Setter
@NoArgsConstructor
public class ItemSaveRequestDto {
    private String itemName;
    private Integer price;
    private Integer quantity;

    @Builder
    public ItemSaveRequestDto(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public Item toEntity() {
        return Item.builder()
                .itemName(itemName)
                .price(price)
                .quantity(quantity)
                .build();
    }

}
