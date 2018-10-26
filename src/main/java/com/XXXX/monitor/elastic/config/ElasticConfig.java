package com.XXXX.monitor.elastic.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by dongdongqin on 2018-04-15.
 *

 */

@Configuration
@EnableElasticsearchRepositories(basePackages = "org/springframework/data/elasticsearch/repositories")
public class ElasticConfig {

    private static final String CLUSTER_NAME = "cluster.name";
    private static final String XPACK_security_USER = "xpack.security.user";
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Value("${elastic.cluster.name}")
    private String clusterName;

    @Value("${elastic.cluster.user.name}")
    private String elasticUserName;

    @Value("${elastic.cluster.password}")
    private String elasticPassword;

    /* currently, only one host is available */
    @Value("${elastic.cluster.host}")
    private String elasticHost;

    /* currently, only one host is available */
    @Value("${elastic.client.transport.sniff}")
    private String clientTransportSniff;

    /**
     *
     * @return
     *
     * client.transport.sniff = true, this configuration
     * will result in socketConnection timeout
     */
    @Bean
    public TransportClient transportClient() {

        Settings esSettings = Settings.builder()
                .put(CLUSTER_NAME, clusterName)
                .put(XPACK_security_USER, elasticUserName + ":" + elasticPassword)
                .put(clientTransportSniff, false)
                .build();
        TransportClient client = new PreBuiltXPackTransportClient(esSettings);

        try {

            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(elasticHost), 9300))
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(elasticHost), 9301));
        }catch (UnknownHostException ex) {

            logger.error("elastic host unknown " + ex);
        }

        return client;

    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(transportClient());
    }


}
