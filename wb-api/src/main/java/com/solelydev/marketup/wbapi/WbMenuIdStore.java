package com.solelydev.marketup.wbapi;

import com.solelydev.marketup.wbapi.model.MainMenuResponse.Menu;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class WbMenuIdStore {
  private final WbApi wbApi;
  private final ConcurrentHashMap<String, Integer> store = new ConcurrentHashMap<>();

  public WbMenuIdStore(WbApi wbApi) {
    this.wbApi = wbApi;
    init();
  }

  private void init() {
    checkAndFillStore();
  }

  // TODO периодически обновлять map
  // TODO Лочить доступ во время обновления
  public void checkAndFillStore() {
    var menu = wbApi.getMainMenu();
    store.clear();
    extractMenuIdRecursively(menu);
  }

  public Optional<Integer> getMenuId(String url) {
    return Optional.ofNullable(store.get(url));
  }

  private <T extends Menu> void extractMenuIdRecursively(List<T> menus) {
    if (menus == null || menus.isEmpty()) {
      return;
    }

    for (Menu menu : menus) {
      store.put(menu.getUrl(), menu.getId());
      extractMenuIdRecursively(menu.getChilds());
    }
  }
}
