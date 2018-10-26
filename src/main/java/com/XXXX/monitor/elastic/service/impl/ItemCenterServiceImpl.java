package com.XXXX.monitor.elastic.service.impl;

import com.XXXX.monitor.elastic.model.ItemCenterModel;
import com.XXXX.monitor.elastic.service.ItemCenterService;
import com.XXXX.monitor.elastic.repository.ItemCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dongdongqin on 2018-04-16.
 */
@Service
public class ItemCenterServiceImpl implements ItemCenterService {

    @Autowired
    private ItemCenterRepository itemCenterRepository;

    @Override
    public List<ItemCenterModel> findByMethod(String method) {
        return itemCenterRepository.findByMethod(method);
    }

}
