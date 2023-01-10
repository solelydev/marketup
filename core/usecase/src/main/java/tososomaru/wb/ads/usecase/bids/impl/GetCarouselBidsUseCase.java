package tososomaru.wb.ads.usecase.bids.impl;

import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.bids.CarouselBids;
import tososomaru.wb.ads.bids.CurrentBid;
import tososomaru.wb.ads.common.types.SKU;
import tososomaru.wb.ads.usecase.bids.GetCarouselBids;
import tososomaru.wb.ads.wbapi.WbApi;
import tososomaru.wb.ads.wbapi.model.CarouselAdsResponse;

import java.util.List;
import java.util.function.Predicate;

@AllArgsConstructor
@Component
public class GetCarouselBidsUseCase implements GetCarouselBids {

    private final WbApi wbApi;

    @Override
    public Either<GetCarouselBidsError, CarouselBids> execute(String itemNumberOrUrl) {

        return SKU.create(itemNumberOrUrl)
                .map(SKU::getValue)
                .mapLeft(e -> (GetCarouselBidsError)new GetCarouselBidsError.CreateSKU("Please provide correct SKUs request"))
                .map(wbApi::getCarouselAds)
                .map(resp -> carouselAdsResponseToCarouselBids(resp, itemNumberOrUrl))
                .flatMap(resp -> resp.fold(
                        () -> Either.left(new GetCarouselBidsError.BidsNotFound()), Either::right)
                );
    }

    private Option<CarouselBids> carouselAdsResponseToCarouselBids(Option<CarouselAdsResponse> response, String rawRequest) {
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
                ads.getSubjectId()
        );
    }
}
