package pattern2_structural.struct6_proxy.code.example2_cache_youtube;

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
