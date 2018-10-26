package com.XXXX.monitor.elastic.service.impl;
/**
 *   Created by dongdongqin on 2018-04-15.
 */

import com.XXXX.monitor.elastic.model.TemplateModel;
import com.XXXX.monitor.elastic.repository.TemplateRepository;
import com.XXXX.monitor.elastic.service.TemplateOnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TemplateOnServiceImpl implements TemplateOnService {


    @Autowired
    private TemplateRepository templateRepository;


    @Override
    public List<TemplateModel> findByTitle(String title) {
        return templateRepository.findByTitle(title);
    }

    @Override
    public Optional<TemplateModel> findById(String id) {
        return templateRepository.findById(id);
    }


}
