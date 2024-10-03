package pattern2_structural.struct6_proxy.code.example1_cache;

public class DataServiceImpl implements DataService {

    @Override
    public String fetchData(String parameter) {
        // Симуляция дорогостоящей операции, например, запрос к внешнему API
        simulateExpensiveOperation();
        return "Data for " + parameter;
    }

    private void simulateExpensiveOperation() {
        try {
            System.out.println("Fetching data from external source...");
            Thread.sleep(3000); // Симуляция задержки 3 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
