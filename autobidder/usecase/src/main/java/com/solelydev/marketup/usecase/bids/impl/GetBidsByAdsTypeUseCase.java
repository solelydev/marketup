package com.solelydev.marketup.usecase.bids.impl;

import com.solelydev.marketup.bids.Bids;
import com.solelydev.marketup.bids.RequestBids;
import com.solelydev.marketup.common.AdsType;
import com.solelydev.marketup.usecase.bids.GetBidsByAdsType;
import com.solelydev.marketup.usecase.bids.GetCarouselBids;
import com.solelydev.marketup.usecase.bids.GetCategoryBids;
import com.solelydev.marketup.usecase.bids.GetSearchBids;
import com.solelydev.marketup.usecase.bids.history.AddBidRequestToHistory;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetBidsByAdsTypeUseCase implements GetBidsByAdsType {
  private final GetCarouselBids getCarouselBids;
  private final GetCategoryBids getCategoryBids;
  private final GetSearchBids getSearchBids;
  private final AddBidRequestToHistory addBidRequestToHistory;

  @Override
  public Either<?, Bids> execute(String request, String adsType) {
    // TODO check enum
    var adsTypeE = AdsType.valueOf(adsType.toUpperCase());
    var bids =
        switch (adsTypeE) {
          case SEARCH -> getSearchBids.execute(request);
          case CATEGORY -> getCategoryBids.execute(request);
          case CAROUSEL -> getCarouselBids.execute(request);
        };

    return bids.peek(b -> addBidRequestToHistory.execute(new RequestBids(request, b)))
        .map(Bids.class::cast);
  }
}
