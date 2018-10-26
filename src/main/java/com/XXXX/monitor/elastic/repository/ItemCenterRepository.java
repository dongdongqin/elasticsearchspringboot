package com.XXXX.monitor.elastic.repository;

import com.XXXX.monitor.elastic.model.ItemCenterModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by dongdongqin on 2018-04-16.
 */
public interface ItemCenterRepository extends ElasticsearchRepository<ItemCenterModel, String> {

    List<ItemCenterModel> findByMethod(String method);

}
