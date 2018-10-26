package com.XXXX.monitor.elastic;

import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by dongdongqin on 2018-04-15.
 */
@RestController
@RequestMapping(path = "/health")
public class HealthController {

    @Autowired
    private ElasticsearchOperations es;
    private Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * application health checking
     * @return
     */
    @RequestMapping("/application_health")
    public String index() {
        return "OK";
    }

    /**
     * elastic info health checking
     * @return
     */
    @RequestMapping("/elasticinfo_health")
    public Map<String, String> elasticInfo() {

        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();
        asMap.forEach((k, v) -> {
            logger.info(k + "=" + v);
        });
        return asMap;
    }

}
