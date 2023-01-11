package com.solelydev.marketup.common.types;

import com.solelydev.marketup.common.base.ValueObject;
import java.net.URI;
import java.util.Objects;
import java.util.stream.Stream;

/** Ключевое слово запроса */
public class SearchKeyword implements ValueObject {
  private final String value;

  private SearchKeyword(String value) {
    this.value = value;
  }

  public static SearchKeyword from(String keyword) {
    return new SearchKeyword(keyword);
  }

  public static SearchKeyword from(URI uri) {
    var keyword =
        Stream.of(uri.getQuery().split("&"))
            .map(queryPart -> queryPart.split("="))
            .filter(q -> Objects.equals(q[0], "search"))
            .map(q -> q[1])
            .findFirst();

    return keyword.map(SearchKeyword::from).orElseThrow(() -> new RuntimeException("invalid uri"));
  }

  public static SearchKeyword create(String keywordOrUrl) {
    try {
      return from(URI.create(keywordOrUrl));
    } catch (Exception ignored) {
      return from(keywordOrUrl);
    }
  }

  public String getValue() {
    return value;
  }
}
