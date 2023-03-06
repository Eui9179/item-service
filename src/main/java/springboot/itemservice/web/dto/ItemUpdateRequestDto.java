package springboot.itemservice.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemUpdateRequestDto {
    private String itemName;
    private Integer price;
    private Integer quantity;

    @Builder
    public ItemUpdateRequestDto(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
