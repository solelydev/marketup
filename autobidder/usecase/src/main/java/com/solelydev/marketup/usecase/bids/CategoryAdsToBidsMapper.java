package com.solelydev.marketup.usecase.bids;

import com.solelydev.marketup.bids.CurrentBid;
import com.solelydev.marketup.wbapi.model.CategoryAdsResponse;
import java.util.ArrayList;
import java.util.List;

public class CategoryAdsToBidsMapper {
  public List<CurrentBid> execute(CategoryAdsResponse categoryAds) {
    var currentBids = new ArrayList<CurrentBid>();

    var adverts = categoryAds.getAdverts().stream().limit(categoryAds.getPages().size()).toList();

    for (int i = 0; i < adverts.size(); i++) {
      var advert = adverts.get(i);
      var pageNumber = i / 10;
      // TODO сортировать страницы
      var page = categoryAds.getPages().get(pageNumber);
      var position = page.getPositions().get(i % 10);
      // TODO найти способ получать deliveryTime
      // TODO найти способ получать категорию товара
      var currentBid =
          new CurrentBid(i, advert.getId(), position, pageNumber, advert.getCpm(), 0, 0);
      currentBids.add(currentBid);
    }
    return currentBids;
  }
}
