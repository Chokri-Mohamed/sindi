package tech.byrsa.sindibad.configuration;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories("tech.byrsa.sindibad.database.elastic")
@ComponentScan(basePackages = { "tech.byrsa.sindibad.adapter.*" })
public class ElasticConfig extends AbstractElasticsearchConfiguration {


    //pass: HcswhBngvFCFAX2i_xaz
    private String pass = "IPh3M91-s=xj9vC2ejLS";
    //username: elastic
    private String user = "elastic";
    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .withBasicAuth(user, pass)
                .build();

        return RestClients.create(clientConfiguration)
                .rest();
    }
}