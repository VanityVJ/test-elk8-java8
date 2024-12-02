@Service
public class ElasticsearchService {

    @Autowired
    private RestHighLevelClient client;

    public List<Map<String, Object>> search(String query) throws IOException {
        SearchRequest searchRequest = new SearchRequest("_all");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder(); 

        searchSourceBuilder.query(QueryBuilders.matchQuery("", 
 query));

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT); 


        List<Map<String, Object>> results = new ArrayList<>(); 

        SearchHit[] searchHits = searchResponse.getHits().getHits();
        for (SearchHit hit : searchHits) {
            results.add(hit.getSourceAsMap());
        }

        return results;
    }
}