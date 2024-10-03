package pattern2_structural.struct6_proxy.code.example1_cache;

public class CachingProxyMain {
    public static void main(String[] args) {
        // Создание реального объекта DataService
        DataService realDataService = new DataServiceImpl();

        // Создание прокси с функциональностью кэширования
        DataService cachingProxy = new CachingDataServiceProxy(realDataService);

        // Первый запрос с параметром "param1" — данные будут загружены и закэшированы
        System.out.println("First request:");
        String data1 = cachingProxy.fetchData("param1");
        System.out.println("Received: " + data1);

        System.out.println();

        // Второй запрос с тем же параметром "param1" — данные будут получены из кэша
        System.out.println("Second request:");
        String data2 = cachingProxy.fetchData("param1");
        System.out.println("Received: " + data2);

        System.out.println();

        // Запрос с новым параметром "param2" — данные будут загружены и закэшированы
        System.out.println("Third request:");
        String data3 = cachingProxy.fetchData("param2");
        System.out.println("Received: " + data3);

        System.out.println();

        // Повторный запрос с параметром "param2" — данные будут получены из кэша
        System.out.println("Fourth request:");
        String data4 = cachingProxy.fetchData("param2");
        System.out.println("Received: " + data4);
    }
}
