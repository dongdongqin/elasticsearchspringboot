package com.XXXX.monitor.elastic.repository;

import com.XXXX.monitor.elastic.model.TemplateModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by dongdongqin on 2018-04-15.

 */

public interface TemplateRepository extends ElasticsearchRepository<TemplateModel, String> {

    List<TemplateModel> findByTitle(String title);
    Optional<TemplateModel> findById(String id);


}

