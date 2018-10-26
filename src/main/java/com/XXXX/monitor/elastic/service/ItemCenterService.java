package com.XXXX.monitor.elastic.service;

import com.XXXX.monitor.elastic.model.ItemCenterModel;

import java.util.List;

/**
 * Created by dongdongqin on 2018-04-16.
 */
public interface ItemCenterService {

    List<ItemCenterModel> findByMethod(String method);

}
