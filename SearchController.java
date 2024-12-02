@RestController
public class SearchController {

    @Autowired
    private ElasticsearchService elasticsearchService;

    @GetMapping("/search")

    public List<Map<String, Object>> search(@RequestParam String query) throws IOException {
        return elasticsearchService.search(query);
    }
}