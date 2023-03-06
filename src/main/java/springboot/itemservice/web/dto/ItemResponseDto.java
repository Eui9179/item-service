package springboot.itemservice.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.itemservice.domain.item.Item;

@Getter
@NoArgsConstructor
public class ItemResponseDto {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public ItemResponseDto(Item entity) {
        this.id = entity.getId();
        this.itemName = entity.getItemName();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();
    }

}
