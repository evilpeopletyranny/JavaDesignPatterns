package structural.proxy.code;

/**
 * Пример использование прокси кэширования youtube сервиса.
 */
public class Main {
    public static void main(String[] args) {
        var youtubeService = new ThirdPartyYoutubeClass();
        var youtubeProxy = new CachedYoutubeProxy();

        //набор методов один и тот же, но в прокси есть кэш
        System.out.println(youtubeService.getVideoList());
        System.out.println(youtubeProxy.getVideoList());

        System.out.println("------------------------------");

        System.out.println(youtubeService.getVideoName(1));
        System.out.println(youtubeProxy.getVideoName(1));

        System.out.println("------------------------------");

        System.out.println(youtubeService.downloadVideo(1));
        System.out.println(youtubeProxy.downloadVideo(1));
    }
}
