//package springboot.itemservice.web.basic;
//
//import springboot.itemservice.domain.item.Item;
//import springboot.itemservice.domain.item.ItemRepository2;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
//@Controller
//@RequestMapping("/basic/items")
//@RequiredArgsConstructor //final이 붙은 변수를 최기화 해준다. @Autowired
//public class BasicItemController {
//    private final ItemRepository2 itemRepository2;
//
//    @GetMapping
//    public String items(Model model) {
//        List<Item> items = itemRepository2.findAll();
//        model.addAttribute("items", items);
//        return "basic/items";
//    }
//
//    @GetMapping("/{itemId}")
//    public String item(@PathVariable long itemId, Model model) {
//        Item item = itemRepository2.findById(itemId);
//        model.addAttribute("item", item);
//        return "basic/item";
//    }
//
//    @GetMapping("/add")
//    public String addForm() {
//        return "basic/addForm";
//    }
//
////    @PostMapping("/add")
//    public String addItemV1(
//            @RequestParam String itemName,
//            @RequestParam int price,
//            @RequestParam Integer quantity,
//            Model model) {
//
//        Item item = new Item(itemName, price, quantity);
//        itemRepository2.save(item);
//
//        model.addAttribute("item", item);
//
//        return "basic/item";
//    }
//
////    @PostMapping("/add")
//    public String addItemV2(@ModelAttribute("item") Item item, Model model) {
//        // 넘어오는 데이터를 자동으로 맵핑해서 Item으로 만들어줌
//        itemRepository2.save(item);
//        model.addAttribute("item", item);
//
//        return "basic/item";
//    }
//
////    @PostMapping("/add")
//    public String addItemV3(@ModelAttribute("item") Item item, Model model) {
//        // @ModelAttribute는 2가지 기능을 하는데
//        // 1. Item 객체를 생성한다.
//        // 2. Model에 @ModelAttribute가 지정한 객체를 자동으로 넣어준다.
//        // @ModelAttribute("item")을 통해서 "item"으로 속성을 만들어준다.
//        // 만약 @ModelAttribute라고만 적으면 자동으로 클래스의 앞글자를 소문자로 바꾸어 자동으로 넣어준다.
//        // ex) HelloData -> helloData
//        // ex) Item -> item
//        itemRepository2.save(item);
////        model.addAttribute("item", item);
//        return "basic/item";
//    }
//
////    @PostMapping("/add")
//    public String addItemV4(Item item) {
//        // @ModelAttribute 생략 가능
//        // PRG 패턴
//        // Post - Redirect - Get
//        // 문제점: + item.get() 이렇게 넣으면 인코딩이 되지 않고 넘어가기 때문에 위험하다
//        itemRepository2.save(item);
//        return "redirect:/basic/items/" + item.getId();
//    }
//
//    @PostMapping("/add")
//    public String addItemV5(Item item, RedirectAttributes redirectAttributes) {
//        /**
//         * RedirectAttribute를 사용하면 리다이렉트에 값을 보낼 수 있고
//         * 인코딩 문제도 자동으로 해결된다.
//         * 치환이 되면 변수로 넘어가고 치환이 되지 않으면 Query Parameter로 넘어간다.
//         */
//        Item savedItem = itemRepository2.save(item);
//        redirectAttributes.addAttribute("itemId", savedItem.getId());
//        redirectAttributes.addAttribute("status", true);
//        return "redirect:/basic/items/{itemId}";
//    }
//
//    @GetMapping("{itemId}/edit")
//    public String editForm(@PathVariable long itemId, Model model) {
//        Item item = itemRepository2.findById(itemId);
//        model.addAttribute("item", item);
//        return "/basic/editForm";
//    }
//
//    @PostMapping("{itemId}/edit")
//    public String editItem(@PathVariable long itemId, Item item) {
//        itemRepository2.update(itemId, item);
//        return "redirect:/basic/items/{itemId}";
//    }
//
//    /**
//     * 테스트용 데이터 추가
//     */
//    @PostConstruct
//    public void init() {
//        itemRepository2.save(new Item("아이폰", 10000, 10));
//        itemRepository2.save(new Item("맥북", 20000, 20));
//    }
//
//}