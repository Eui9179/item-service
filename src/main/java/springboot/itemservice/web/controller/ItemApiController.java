package springboot.itemservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springboot.itemservice.service.item.ItemService;
import springboot.itemservice.web.dto.ItemResponseDto;
import springboot.itemservice.web.dto.ItemSaveRequestDto;
import springboot.itemservice.web.dto.ItemUpdateRequestDto;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/items")
public class ItemApiController {

    private final ItemService itemService;

    @PostMapping
    public Long save(@RequestBody ItemSaveRequestDto requestDto) {
        return itemService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody ItemUpdateRequestDto requestDto) {
        return itemService.update(id, requestDto);
    }

    @GetMapping("/{id}")
    public ItemResponseDto findById(@PathVariable Long id) {
        return itemService.findById(id);
    }
}
