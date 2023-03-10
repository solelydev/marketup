package com.solelydev.marketup.usecase.bids;

import com.solelydev.marketup.bids.CurrentBid;
import com.solelydev.marketup.wbapi.model.SearchAdsResponse;
import java.util.ArrayList;
import java.util.List;

public class SearchAdsToBidsMapper {

  public List<CurrentBid> execute(SearchAdsResponse catalogAds) {
    var currentBids = new ArrayList<CurrentBid>();

    var adverts = catalogAds.getAdverts();

    for (int i = 0; i < adverts.size(); i++) {
      var advert = adverts.get(i);
      var pageNumber = i / 10;
      // TODO сортировать страницы
      var page = catalogAds.getPages().get(pageNumber);
      var position = page.getPositions().get(i % 10);
      // TODO найти способ получать deliveryTime
      var currentBid =
          new CurrentBid(
              i, advert.getId(), position, pageNumber + 1, advert.getCpm(), 0, advert.getSubject());
      currentBids.add(currentBid);
    }
    return currentBids;
  }
}
