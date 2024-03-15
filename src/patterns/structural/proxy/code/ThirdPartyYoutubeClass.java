package patterns.structural.proxy.code;

import java.util.List;

/**
 * Конкретная реализация сервиса, который будет обернут в прокси.
 */
public class ThirdPartyYoutubeClass {
    private final List<Video> downloadedVideo = List.of(
            new Video(1, "Учимся программировать на Java."),
            new Video(2, "Изучаем паттерны проектирования на Java."),
            new Video(3, "Использование современных фреймоврков, реализующий паттерны проектирования."),
            new Video(4, "использование паттренов проектирования в мультипоточном программировании."));

    public List<Video> getVideoList() {
        return downloadedVideo;
    }

    public String getVideoName(Integer id) {
        return downloadedVideo.stream().filter(video -> video.id().equals(id)).findFirst().get().name();
    }

    public Video downloadVideo(Integer id) {
        return downloadedVideo.stream().filter(video -> video.id().equals(id)).findFirst().get();
    }
}
