//package springboot.itemservice.domain.item;
//
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ItemRepository2 {
//
//    private static final Map<Long, Item> store = new HashMap<>();
//    private static long sequence = 0L;
//
//    public Item save(Item item) {
//        store.put(item.getId(), item);
//        return item;
//    }
//
//    public Item findById(Long id) {
//        return store.get(id);
//    }
//
//    public List<Item> findAll() {
//        return new ArrayList<>(store.values());
//    }
//
//    public void update(Long id, Item updateParam) {
//        Item item = findById(id);
//    }
//
//    public void clearStore() {
//        store.clear();
//    }
//}
