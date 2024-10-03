package pattern2_structural.struct6_proxy.code.example2_cache_youtube;

import java.util.List;
import java.util.Objects;

/**
 * Пример "умного"/кешируюего прокси на сервисом
 * ThirdPartyYoutubeClass.
 * <p>
 * Прокси должен реализовывать интерфейс, аналогичный используемому сервису.
 * <p>
 * Пример простой и надуманный, но показательный.
 */
public class CachedYoutubeProxy implements ThirdPartyYoutubeLib {
    /**
     * Сервис, который "заворачивается" в прокси
     */
    private ThirdPartyYoutubeClass thirdPartyYoutubeClass = new ThirdPartyYoutubeClass();
    private List<Video> listCache;
    private Video videoCache;

    /**
     * В конструктор передаем ссылку на сервис.
     * Если у нас предусматривается только одно прокси, то в общем-то можно инициализировать поле сразу.
     */
    public CachedYoutubeProxy() {
    }

    /**
     * Получение списка видео.
     * Сначала выолняется проверка не лежит ли данный список в кэше.
     * Последний загруженный список становится кэшированным.
     *
     * @return список видео.
     */
    @Override
    public List<Video> getVideoList() {
        if (Objects.isNull(listCache) || listCache.isEmpty()) listCache = thirdPartyYoutubeClass.getVideoList();
        return listCache;
    }

    /**
     * Получение имени видео.
     * Сначала прверяется не лежит ли данное видео в кэше.
     * Последнее загруженное видео становиться кэшированным.
     *
     * @param id видое имя которого необходимо найти
     * @return имя видео
     */
    @Override
    public String getVideoName(Integer id) {
        if (Objects.isNull(videoCache) || !videoCache.id().equals(id))
            videoCache = thirdPartyYoutubeClass.downloadVideo(id);
        return videoCache.name();
    }

    /**
     * Получение видео.
     * Сначала прверяется не лежит ли данное видео в кэше.
     * Последнее загруженное видео становиться кэшированным.
     *
     * @param id видео которое необходимо найти
     * @return найденное видео
     */
    @Override
    public Video downloadVideo(Integer id) {
        if (Objects.isNull(videoCache) || !videoCache.id().equals(id))
            videoCache = thirdPartyYoutubeClass.downloadVideo(id);
        return videoCache;
    }
}
