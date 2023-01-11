package com.solelydev.marketup.wbapi.model;

import java.util.List;
import lombok.Value;

@Value
public class CategoryAdsResponse implements CatalogAdsResponse {
  List<Page> pages;
  List<Integer> prioritySubjects;
  List<Advert> adverts;
  Integer minCPM;

  @Value
  public static class Page {
    List<Integer> positions;
    Integer page;
    Integer count;
  }

  @Value
  public static class Advert {
    String code;
    // идентификатор рекламной кампании
    Integer advertId;
    // артикул товара
    Integer id;
    // cost per millenium, ставка за 1000 показов, установленная продавцом
    Integer cpm;
  }
}
