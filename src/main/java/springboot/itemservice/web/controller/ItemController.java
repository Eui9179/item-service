package springboot.itemservice.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot.itemservice.domain.item.Item;
import springboot.itemservice.service.item.ItemService;
import springboot.itemservice.web.dto.ItemResponseDto;
import springboot.itemservice.web.dto.ItemSaveRequestDto;
import springboot.itemservice.web.dto.ItemUpdateRequestDto;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/tl")
public class ItemController {
    private final ItemService itemService;

    /* Get */
    @GetMapping("/items")
    public String findAll(Model model) {
        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);
        return "/basic/items";
    }

    @GetMapping("/item/{id}")
    public String findItem(@PathVariable Long id, Model model) {
        ItemResponseDto responseDto = itemService.findById(id);
        model.addAttribute("item", responseDto);
        return "basic/item";
    }

    /* Save */
    @GetMapping("/item/form")
    public String tlAddForm(){
        return "/basic/addForm";
    }

    @PostMapping("/item")
        public String saveItem(ItemSaveRequestDto item, RedirectAttributes redirectAttributes) {
        Long id = itemService.save(item);
        redirectAttributes.addAttribute("id", id);
        redirectAttributes.addAttribute("status", true);
        return "redirect:/tl/item/{id}";
    }

    /* Update */
    @GetMapping("/item/{id}/edit")
    public String updateForm(@PathVariable Long id, Model model) {
        ItemResponseDto item = itemService.findById(id);
        model.addAttribute("item", item);
        return "/basic/editForm";
    }

    @PostMapping("/item/{id}/edit")
    public String updateItem(
            @PathVariable Long id,
            ItemUpdateRequestDto item,
            RedirectAttributes redirectAttributes) {
        itemService.update(id, item);
        redirectAttributes.addAttribute("id", id);
        return "redirect:/tl/item/{id}";
    }

    @PostConstruct
    public void init() {
        itemService.save(ItemSaveRequestDto.builder()
                .itemName("test1")
                .price(10000)
                .quantity(10)
                .build());
        itemService.save(ItemSaveRequestDto.builder()
                .itemName("test2")
                .price(20000)
                .quantity(20)
                .build());
    }
}
