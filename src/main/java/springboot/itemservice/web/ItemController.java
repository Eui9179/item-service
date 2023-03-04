package springboot.itemservice.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot.itemservice.service.item.ItemService;
import springboot.itemservice.web.dto.ItemSaveRequestDto;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public String addForm() {
        return "basic/addForm";
    }

    @PostMapping
    public String saveItem(ItemSaveRequestDto requestDto, RedirectAttributes redirectAttributes) {
        Long id = itemService.save(requestDto);
        redirectAttributes.addAttribute("itemId", id);
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/items/{itemId}";
    }
}
