package com.solelydev.marketup.wbapi.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Value;

public class MainMenuResponse extends ArrayList<MainMenuResponse.Catalog> {

  @Value
  public static class Catalog implements Menu {
    Integer id;
    Boolean landing;
    String name;
    String query;
    String shard;
    String url;
    List<Category> childs;
  }

  @Value
  public static class Category implements Menu {
    Integer id;
    String name;
    Integer parent;
    String query;
    String seo;
    String shard;
    String url;
    List<Category> childs;
  }

  public interface Menu extends WithChilds {
    Integer getId();

    String getName();

    String getUrl();
  }

  public interface WithChilds {
    List<Category> getChilds();
  }
}
