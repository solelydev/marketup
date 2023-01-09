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
        var endpoint = "https://wbx-content-v2.wbstatic.net/ru/27765179.json";
        return null;
    }

    public MainMenuResponse getMainMenu() {
        var endpoint = "https://www.wildberries.ru/webapi/menu/main-menu-ru-ru.json";
        var uri = URI.create(endpoint);
        var request = HttpRequest.newBuilder().GET().uri(uri).build();

        var client = HttpClient.newHttpClient();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), MainMenuResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public SearchAdsResponse getCatalogAds(String keyword) {
        String endpoint = "https://catalog-ads.wildberries.ru/api/v5/search?keyword="
                + URLEncoder.encode(keyword, StandardCharsets.UTF_8);

        URI uri = URI.create(endpoint);
        HttpRequest request = HttpRequest
                .newBuilder()
                .GET()
                .uri(uri)
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), SearchAdsResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CategoryAdsResponse getCategoryAds(Integer menuId) {
        String endpoint = "https://catalog-ads.wildberries.ru/api/v5/catalog?menuid=" + menuId;

        URI uri = URI.create(endpoint);
        HttpRequest request = HttpRequest
                .newBuilder()
                .GET()
                .uri(uri)
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), CategoryAdsResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CarouselAdsResponse getCarouselAds(Integer itemNumber) {
        String endpoint = "https://carousel-ads.wildberries.ru/api/v4/carousel?nm=" + itemNumber;

        URI uri = URI.create(endpoint);
        HttpRequest request = HttpRequest
                .newBuilder()
                .GET()
                .uri(uri)
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), CarouselAdsResponse.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
