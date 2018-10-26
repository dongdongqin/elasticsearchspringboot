package com.XXXX.monitor.elastic;

import com.XXXX.monitor.elastic.model.ItemCenterModel;
import com.XXXX.monitor.elastic.model.TemplateModel;
import com.XXXX.monitor.elastic.service.ItemCenterService;
import com.XXXX.monitor.elastic.repository.ItemCenterRepository;
import com.XXXX.monitor.elastic.service.TemplateOnService;
import org.apache.commons.collections4.CollectionUtils;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


/**
 * Created by dongdongqin on 2018-04-15.
 */
@RestController
@RequestMapping(path = "/elastic")
public class ElasticController {

    @Autowired
    private TransportClient transportClient;

    @Autowired
    private ItemCenterService itemCenterService;

    @Autowired
    private TemplateOnService templateOnService;

    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    private ItemCenterRepository itemCenterRepository;

    /**
     * for testing controller
     *
     * @return
     */
    @GetMapping("/query/index")
    public List<TemplateModel> queryfortest1() {

        //TODO for testing
        List<TemplateModel> templateModels = templateOnService.findByTitle("我的广告22");
        Optional<TemplateModel> templateModel = templateOnService.findById("100");
        if (templateModel.isPresent()) {
           System.out.println(templateModel.get().getName());
        }
        return templateModels;
    }

    @GetMapping("/query/index2")
    public List<ItemCenterModel> queryfortest2() {

       List<ItemCenterModel> itemCenterModels = itemCenterService.findByMethod("GET");

       Optional<ItemCenterModel> itemCenter = itemCenterRepository.findById("AWLNXxsednz-9gQ3A6GS");

       if(itemCenter.isPresent()) {
           System.out.println("testing is successfully");
           System.out.println(itemCenter.get().getMessage());
       }

        /**
         * for testing, it does not work
         * non blocked
         */
       if(CollectionUtils.isEmpty(itemCenterModels)) {

           itemCenterModels.stream().forEach(itemCenterModel -> {

               System.out.println(itemCenterModel.getMessage());
           });

       }

        return itemCenterModels;
    }

}
