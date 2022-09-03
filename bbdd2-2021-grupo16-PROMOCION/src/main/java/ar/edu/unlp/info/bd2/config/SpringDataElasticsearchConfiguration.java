package ar.edu.unlp.info.bd2.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import ar.edu.unlp.info.bd2.services.MLService;
import ar.edu.unlp.info.bd2.services.SpringDataMLService;
import ar.edu.unlp.info.bd2.utils.DBInitializer;

@Configuration
@EnableElasticsearchRepositories(basePackages = "ar.edu.unlp.info.bd2.repositories")
//@EnableTransactionManagement // conficto con elasticsearch ...
public class SpringDataElasticsearchConfiguration extends AbstractElasticsearchConfiguration {

	@Bean
	public MLService springDataElasticsearchService() {
		return new SpringDataMLService();
	}

	@Bean
	public DBInitializer createDBInitializer() {
		return new DBInitializer();
	}

	@Override
	@Bean
	public RestHighLevelClient elasticsearchClient(){
		ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo("localhost:9200").build();
		return RestClients.create(clientConfiguration).rest();
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception{
		return new ElasticsearchRestTemplate(elasticsearchClient());
	}
}
