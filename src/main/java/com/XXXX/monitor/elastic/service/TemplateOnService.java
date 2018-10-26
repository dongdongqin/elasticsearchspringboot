package com.XXXX.monitor.elastic.service;


import com.XXXX.monitor.elastic.model.TemplateModel;

import java.util.List;
import java.util.Optional;


/**
 * Created by dongdongqin on 2018-04-15.
 *
 *  */

public interface TemplateOnService {

    List<TemplateModel> findByTitle(String title);
    Optional<TemplateModel> findById(String id);
}
