package DocVers.creation;

import java.time.Duration;
import java.util.concurrent.*;

public class MoreConvenientCreationMethods {
    //Реализация интерфейса Callable
    public static class MyCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            Thread.sleep(Duration.ofSeconds(1).toMillis());
            return "this string has been processed in MyCallable";
        }
        //Демонстрация работы с Callable.
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            //Создаём наш Callable
            MyCallable myCallable = new MyCallable();
            //Заворачиваем его в FutureTask
            FutureTask<String> futureTask = new FutureTask<>(myCallable);
            //создаём для Future новый поток и запускаем его на исполнение
            new Thread(futureTask).start();
            //Пишем что-то в консоль и проверяем, исполнился ли наш Future
            System.out.println("some print in main");
            System.out.println("is future completed: "+futureTask.isDone());

            //Ожидаем завершения выполнения нашего Future и выводим результат в консоль
            System.out.println(futureTask.get());
        }
    }

}
