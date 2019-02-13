package com.panda.framework.config;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jamie
 * @ClassName: ElasticSearchConfig
 * @Description: ElasticSearch配置文件
 * @data 2019-01-17 10:19
 **/
@Configuration
@ConfigurationProperties(prefix = "panda")
public class ElasticSearchConfig {

    private String clusterName;

    private String ip;

    private int port;



//    @Bean
//    public TransportClient getTransportClient(){
//
//    }



}
