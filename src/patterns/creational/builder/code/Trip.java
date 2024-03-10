package patterns.creational.builder.code;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Класс поездки, который содержит много-много параметров.
 * Для использования параметров по умолчанию можно
 * поля изначально инициализировать какими-то значениями, либо предоставить это
 * действие билдеру.
 * В данном примере значения по умолчанию будут указываться в билдере.
 */
public class Trip {
    private final LocalDate startDate;          //дата начала поездки
    private final LocalDate endDate;            //дата конца поездки
    public final String start;                  //начальный пункт
    public final String end;                    //конечный пункт
    public final Integer duration;                  //продолжительность
    public final Integer numberTraveller;           //кол-во путешественников
    public final Integer numberKids;                //кол-во детей
    public final Integer minimumStars;              //минимальное кол-во звезд
    public final Integer minimumRecommendations;    //минимальное кол-во рекомендаций
    public final Integer rating;                    //рейтинг
    public final Integer minimumNumberRatings;      //минимальное кол-во отзывов с рейтингом

    /**
     * Большой ужасный конструктор
     */
    public Trip(LocalDate startDate,
                LocalDate endDate,
                String start,
                String end,
                Integer duration,
                Integer numberTraveller,
                Integer numberKids,
                Integer minimumStars,
                Integer minimumRecommendations,
                Integer rating,
                Integer minimumNumberRatings) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.numberTraveller = numberTraveller;
        this.numberKids = numberKids;
        this.minimumStars = minimumStars;
        this.minimumRecommendations = minimumRecommendations;
        this.rating = rating;
        this.minimumNumberRatings = minimumNumberRatings;
    }

    /**
     * Приватный конструктор
     *
     * @param builder на основе чего будет создан новый объект
     */
    private Trip(Builder builder) {
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.start = builder.start;
        this.end = builder.end;
        this.duration = builder.duration;
        this.numberTraveller = builder.numberTraveller;
        this.numberKids = builder.numberKids;
        this.minimumStars = builder.minimumStars;
        this.minimumRecommendations = builder.minimumRecommendations;
        this.rating = builder.rating;
        this.minimumNumberRatings = builder.minimumNumberRatings;
    }

    public static class Builder {
        private LocalDate startDate;
        private LocalDate endDate;
        public String start;
        public String end;
        public Integer duration = 1;                    //по умолчанию продолжительность 1
        public Integer numberTraveller = 1;             //по умолчанию 1 путешесвенник
        public Integer numberKids = 0;                  //по умолчанию 0 детей
        public Integer minimumStars = 3;                //по умолчанию минимум 3 звезды
        public Integer minimumRecommendations = 100;    //минимум 100 отзывов
        public Integer rating = 4;                      //минимуальный рейтинг 4
        public Integer minimumNumberRatings = 20;       //миниумальное кол-во отзывов с рейтингом 20

        /**
         * В конструкторе можно определить несколько значений, которые
         * ВСЕГДА требуют инициализации и НЕ ИМЕЮТ параметров по умолчанию.
         * Или можно вобще все скинуть в отдельные методы - тут уже на ваше усмотрение
         *
         * @param startDate дата начала поездки
         * @param endDate   дата окончания поездки
         * @param start     место начала
         * @param end       место конца
         */
        public Builder(LocalDate startDate,
                       LocalDate endDate,
                       String start,
                       String end) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.start = start;
            this.end = end;
        }

        /**
         * Самый главный метод билдера - build(),
         * в котором создаются новые объекты.
         * В данном случае это делается через приватный конструктор, который
         * принимает билдер.
         *
         * @return созданная поездка
         */
        public Trip build() {
            return new Trip(this);
        }

        //На остальные поля делаются "сеттеры"
        //Эти сеттеры и будут "шагами" для создания объекта
        //ВАЖНОЙ!!! В качестве возвращаемого значения они должны
        //возвращать сам Builder, чтобы можно было
        //продложить вызов цепочки методов.
        public Builder setDuration(Integer duration) {
            this.duration = duration;
            return this;
        }

        public Builder setNumberTraveller(Integer numberTraveller) {
            this.numberTraveller = numberTraveller;
            return this;
        }

        public Builder setNumberKids(Integer numberKids) {
            this.numberKids = numberKids;
            return this;
        }

        public Builder setMinimumStars(Integer minimumStars) {
            this.minimumStars = minimumStars;
            return this;
        }

        public Builder setMinimumRecommendations(Integer minimumRecommendations) {
            this.minimumRecommendations = minimumRecommendations;
            return this;
        }

        public Builder setRating(Integer rating) {
            this.rating = rating;
            return this;
        }

        public Builder setMinimumNumberRatings(Integer minimumNumberRatings) {
            this.minimumNumberRatings = minimumNumberRatings;
            return this;
        }
    }

    @Override
    public boolean equals(Object otherObject) {
        if (Objects.isNull(otherObject)) return false;
        if (this == otherObject) return true;
        if (getClass() != otherObject.getClass()) return false;

        Trip trip = (Trip) otherObject;
        return duration.equals(trip.duration) &&
                numberTraveller.equals(trip.numberTraveller) &&
                numberKids.equals(trip.numberKids) &&
                minimumStars.equals(trip.minimumStars) &&
                minimumRecommendations.equals(trip.minimumRecommendations) &&
                rating.equals(trip.rating) &&
                minimumNumberRatings.equals(trip.minimumNumberRatings) &&
                startDate.equals(trip.startDate) &&
                endDate.equals(trip.endDate) &&
                start.equals(trip.start) &&
                end.equals(trip.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                startDate,
                endDate,
                start,
                end,
                duration,
                numberTraveller,
                numberKids,
                minimumStars,
                minimumRecommendations,
                rating,
                minimumNumberRatings);
    }

    @Override
    public String toString() {
        return "Trip[" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", duration=" + duration +
                ", numberTraveller=" + numberTraveller +
                ", numberKids=" + numberKids +
                ", minimumStars=" + minimumStars +
                ", minimumRecommendations=" + minimumRecommendations +
                ", rating=" + rating +
                ", minimumNumberRatings=" + minimumNumberRatings +
                ']';
    }
}
