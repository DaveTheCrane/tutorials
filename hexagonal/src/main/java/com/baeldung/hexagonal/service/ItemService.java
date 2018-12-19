package com.baeldung.hexagonal.service;

import com.baeldung.hexagonal.model.Item;
import com.baeldung.hexagonal.persistence.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public boolean borrow(String id, String user){
        Item retrieved = itemRepository.retrieve(id);
        if (retrieved != null) {
            publishEvent(retrieved);
            auditRetrieval(retrieved);
        }
        return retrieved != null;
    }

    private void publishEvent(Item retrieved) {
        //do something
    }

    private void auditRetrieval(Item retrieved) {
        //do something
    }
}
