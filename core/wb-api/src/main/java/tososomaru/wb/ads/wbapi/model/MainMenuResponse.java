package tososomaru.wb.ads.wbapi.model;

import lombok.Value;

import java.util.List;

@Value
public class MainMenuResponse {
    List<Catalog> catalogs;

    @Value
    public static class Catalog {
        Integer id;
        Boolean landing;
        String name;
        String query;
        String shard;
        String url;
        List<Category> categories;
    }

    @Value
    public static class Category {
        Integer id;
        String name;
        Integer parent;
        String query;
        String seo;
        String shard;
        String url;
        List<Category> subcategories;
    }
}
