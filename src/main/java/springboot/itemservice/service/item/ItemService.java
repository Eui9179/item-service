package springboot.itemservice.service.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.itemservice.domain.item.Item;
import springboot.itemservice.domain.item.ItemRepository;
import springboot.itemservice.web.dto.ItemResponseDto;
import springboot.itemservice.web.dto.ItemSaveRequestDto;
import springboot.itemservice.web.dto.ItemUpdateRequestDto;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public Long save(ItemSaveRequestDto requestDto) {
        return itemRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ItemUpdateRequestDto requestDto) {
        Item entity = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. " + id));
        entity.update(
                requestDto.getItemName(),
                requestDto.getPrice(),
                requestDto.getQuantity()
        );
        return id;
    }

    public ItemResponseDto findById(Long id) {
        Item entity = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다. " + id));

        return new ItemResponseDto(entity);

    }

}
