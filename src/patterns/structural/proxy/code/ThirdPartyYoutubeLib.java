package patterns.structural.proxy.code;

import java.util.List;

/**
 * Интерфейс удаленного сервиса.
 * Интерфейс имеет тот же функционал, что и заворачиваемый в него объект.
 */
public interface ThirdPartyYoutubeLib {
    List<Video> getVideoList();

    String getVideoName(Integer id);

    Video downloadVideo(Integer id);
}
