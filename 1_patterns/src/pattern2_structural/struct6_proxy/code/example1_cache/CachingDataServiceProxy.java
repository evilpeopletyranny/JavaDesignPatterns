package pattern2_structural.struct6_proxy.code.example1_cache;

import java.util.HashMap;
import java.util.Map;

public class CachingDataServiceProxy implements DataService {
    private DataService realDataService;
    private Map<String, String> cache;

    public CachingDataServiceProxy(DataService realDataService) {
        this.realDataService = realDataService;
        this.cache = new HashMap<>();
    }

    @Override
    public String fetchData(String parameter) {
        if (cache.containsKey(parameter)) {
            System.out.println("Returning cached data for: " + parameter);
            return cache.get(parameter);
        }

        System.out.println("No cache found for: " + parameter + ". Fetching data...");
        String data = realDataService.fetchData(parameter);
        cache.put(parameter, data);
        return data;
    }
}
