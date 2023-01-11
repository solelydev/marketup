package com.solelydev.marketup.usecase.bids.impl;

import com.solelydev.marketup.bids.CarouselBids;
import com.solelydev.marketup.bids.CurrentBid;
import com.solelydev.marketup.common.types.SKU;
import com.solelydev.marketup.usecase.bids.GetCarouselBids;
import com.solelydev.marketup.wbapi.WbApi;
import com.solelydev.marketup.wbapi.model.CarouselAdsResponse;
import io.vavr.control.Either;
import io.vavr.control.Option;
import java.util.List;
import java.util.function.Predicate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetCarouselBidsUseCase implements GetCarouselBids {

  private final WbApi wbApi;

  @Override
  public Either<GetCarouselBidsError, CarouselBids> execute(String itemNumberOrUrl) {

    return SKU.create(itemNumberOrUrl)
        .map(SKU::getValue)
        .mapLeft(
            e ->
                (GetCarouselBidsError)
                    new GetCarouselBidsError.CreateSKU("Please provide correct SKUs request"))
        .map(wbApi::getCarouselAds)
        .map(resp -> carouselAdsResponseToCarouselBids(resp, itemNumberOrUrl))
        .flatMap(
            resp ->
                resp.fold(
                    () -> Either.left(new GetCarouselBidsError.BidsNotFound()), Either::right));
  }

  private Option<CarouselBids> carouselAdsResponseToCarouselBids(
      Option<CarouselAdsResponse> response, String rawRequest) {
    return response
        .map(r -> r.stream().map(this::adsToBid).toList())
        .filter(Predicate.not(List::isEmpty))
        .map(bids -> new CarouselBids(bids, rawRequest));
  }

  private CurrentBid adsToBid(CarouselAdsResponse.Ads ads) {
    return new CurrentBid(
        ads.getPosition(),
        ads.getNmId(),
        ads.getPosition(),
        0,
        ads.getCpm(),
        0,
        ads.getSubjectId());
  }
}
