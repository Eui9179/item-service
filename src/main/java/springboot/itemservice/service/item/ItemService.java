package springboot.itemservice.service.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.itemservice.domain.item.ItemRepository;
import springboot.itemservice.web.dto.ItemSaveRequestDto;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public Long save(ItemSaveRequestDto requestDto) {
        return itemRepository.save(requestDto.toEntity()).getId();
    }

}
