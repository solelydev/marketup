package tososomaru.wb.ads.wbapi;

import com.google.gson.Gson;
import tososomaru.wb.ads.wbapi.model.*;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class WbApi {

    private static final Gson gson = new Gson();

    public CardResponse getCardByNumber(Integer itemNumber) {
        var endpoint = String.format("https://wbx-content-v2.wbstatic.net/ru/%d.json", itemNumber);
        return request(endpoint, CardResponse.class);
    }

    public MainMenuResponse getMainMenu() {
        var endpoint = "https://www.wildberries.ru/webapi/menu/main-menu-ru-ru.json";
        return request(endpoint, MainMenuResponse.class);
    }

    public SearchAdsResponse getSearchAds(String keyword) {
        var endpoint = "https://catalog-ads.wildberries.ru/api/v5/search?keyword="
                + URLEncoder.encode(keyword, StandardCharsets.UTF_8);
        return request(endpoint, SearchAdsResponse.class);
    }

    public CategoryAdsResponse getCategoryAds(Integer menuId) {
        var endpoint = "https://catalog-ads.wildberries.ru/api/v5/catalog?menuid=" + menuId;
        return request(endpoint, CategoryAdsResponse.class);
    }

    public CarouselAdsResponse getCarouselAds(Integer itemNumber) {
        var endpoint = "https://carousel-ads.wildberries.ru/api/v4/carousel?nm=" + itemNumber;
        return request(endpoint, CarouselAdsResponse.class);
    }

    //TODO
    private <T> T request(String endpoint, Class<T> clazz) {
        var uri = URI.create(endpoint);
        var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();

        var client = HttpClient.newBuilder()
                .build();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), clazz);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
