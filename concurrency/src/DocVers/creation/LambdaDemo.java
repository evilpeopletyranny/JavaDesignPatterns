package DocVers.creation;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaDemo {
    //Описание своего функционального интерфейса
    @FunctionalInterface
    interface MyFunctionalInterface<In1, In2, Out> {
        Out execute(In1 in1, In2 in2);
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Лямбда-выражения:


        //Создание объекта при помощи лямбда-выражения
        MyFunctionalInterface<Double, Double, Double> multiply = (in1, in2)->in1*in2;
        //Использование объекта
        System.out.println(multiply.execute(3.0, 4.0));

        //Встроенные функциональные интерфейсы
        //Supplier - поставщик. Ничего не принимает, возвращает указанный тип
        Supplier<Integer> intReader = ()->{
            //ЭТО ПРИМЕР, ТАК ДЕЛАТЬ НЕ НАДО!
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        };
        //Consumer - потребитель. Принимает параметр, возвращает void
        Consumer<Object> printer = (o)-> System.out.println(o.toString());
        //Function - преобразователь. Принимает один тип, возвращает другой
        Function<Double, Integer> doubleIntegerFunction = Double::intValue;

//-------------------------------------------------------------------------------------
        //Runnable и Callable, используя то, что оба - функциональные интерфейсы:


        Runnable r = ()-> System.out.println("Parallelism forever!");
        new Thread(r).start();
        //или напрямую
        new Thread(()->System.out.println("Direct lambdas are cool!")).start();

        Callable<String> someStringTask = () -> "Some callable string";
        FutureTask<String> someFutureString = new FutureTask<>(someStringTask);
        new Thread(someFutureString).start();
        someFutureString.isDone();
        System.out.println(someFutureString.get());

        //или напрямую
        FutureTask<String> someOtherFutureString = new FutureTask<>(()->"String from directly passed lambda!");
        new Thread(someOtherFutureString).start();
        System.out.println(someOtherFutureString.get());
    }
}
