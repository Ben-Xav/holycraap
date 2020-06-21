package com.benmorant.game.holycraap.model.business;

import com.benmorant.game.holycraap.model.dao.PeopleItemDao;
import com.benmorant.game.holycraap.model.entity.PeopleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PeopleItemServiceImpl implements PeopleItemService {

    @Autowired
    PeopleItemDao peopleItemDao;

    @Override
    public PeopleItem saveInBase(PeopleItem peopleItem) {
        return peopleItemDao.save(peopleItem);
    }

}

