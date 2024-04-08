package creational.builder.code;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Использование большого и страшного конструктора вручную
        Trip manualTrip = new Trip(
                LocalDate.now(),
                LocalDate.now().plusDays(14),
                "НГТУ им.Р.Е.Алексеева",
                "IBIS",
                14,
                1,
                0,
                4,
                100,
                4,
                20
        );
        System.out.println(manualTrip);

        //Использование билдера
        //Выглядит проще и понятно что и где мы добавляем
        Trip fromBuilderTrip = new Trip.Builder(
                LocalDate.now(),
                LocalDate.now().plusDays(14),
                "НГТУ им.Р.Е.Алексеева",
                "IBIS"
        )
                .setDuration(14)
                .setNumberTraveller(1)
                .setNumberKids(0)
                .setMinimumStars(4)
                .setMinimumRecommendations(100)
                .setMinimumNumberRatings(4)
                .setMinimumNumberRatings(20)
                .build();
        System.out.println(fromBuilderTrip);

        //Создание через билдер, но с пропуском некоторых параметров
        Trip withoutSomeStepsTip = new Trip.Builder(
                LocalDate.now(),
                LocalDate.now().plusDays(14),
                "НГТУ им.Р.Е.Алексеева",
                "IBIS"
        )
                .setDuration(14)
                .setNumberKids(0)
                .setMinimumRecommendations(100)
                .setMinimumNumberRatings(4)
                .build();
        System.out.println(withoutSomeStepsTip);
    }
}
