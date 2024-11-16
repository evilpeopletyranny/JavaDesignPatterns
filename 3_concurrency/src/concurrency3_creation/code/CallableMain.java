package concurrency3_creation.code;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Логика задачи
        return "Результат задачи, полученный из Callable";
    }
}

public class CallableMain {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        MyCallable callableTask = new MyCallable();

        Future<String> future = executorService.submit(callableTask);

        // Получение результата
        String result = future.get();
        System.out.println("Результат: " + result);

        executorService.shutdown();
    }
}
