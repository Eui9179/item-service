package springboot.itemservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.itemservice.service.item.ItemService;
import springboot.itemservice.web.dto.ItemSaveRequestDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/items")
public class ItemApiController {

    private final ItemService itemService;

    @PostMapping
    public Long save(@RequestBody ItemSaveRequestDto requestDto) {
        return itemService.save(requestDto);
    }
}
