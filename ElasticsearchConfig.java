@Configuration
public class ElasticsearchConfig {

    @Bean
    public RestHighLevelClient client() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder( 

                        new HttpsHost("10.73.1.60", 9200, "https")));
        return client; 

    }
}