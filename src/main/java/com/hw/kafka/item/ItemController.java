package com.hw.kafka.item;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @GetMapping("/hello")
    public String home(){
        return "Hello";
    }
    @GetMapping("/items")
    public Item findById(@RequestParam("itemBrand") String itemBrand,
                         @RequestParam("itemName") String itemName,
                        @RequestParam("itemColor") String itemColor){
        // return itemService.findById(id);
        return new Item(itemBrand, itemName, itemColor);
    }


}
