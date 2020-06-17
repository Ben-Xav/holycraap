package com.benmorant.game.holycraap.model.business;

import com.benmorant.game.holycraap.model.dao.ItemDao;
import com.benmorant.game.holycraap.model.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao ItemDao;

    @Override
    public Item saveInBase(Item item) {
        return ItemDao.save(item);
    }

}

