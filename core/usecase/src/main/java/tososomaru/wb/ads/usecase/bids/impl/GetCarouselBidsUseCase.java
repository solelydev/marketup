package tososomaru.wb.ads.usecase.bids.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.usecase.bids.BidsNotFoundException;
import tososomaru.wb.ads.wbapi.WbApi;
import tososomaru.wb.ads.bids.CarouselBids;
import tososomaru.wb.ads.bids.RequestBids;
import tososomaru.wb.ads.bids.AdsType;
import tososomaru.wb.ads.bids.CurrentBid;
import tososomaru.wb.ads.usecase.bids.history.AddBidRequestToHistory;
import tososomaru.wb.ads.usecase.bids.GetCarouselBids;

@AllArgsConstructor
@Component
public class GetCarouselBidsUseCase implements GetCarouselBids {

    private final WbApi wbApi;
    private final AddBidRequestToHistory addBidRequestToHistory;

    @Override
    public CarouselBids execute(String itemNumber) {
        var itemNumberInt = Integer.valueOf(itemNumber);
        var carouselAds = wbApi.getCarouselAds(itemNumberInt);

        // TODO use either
        if (carouselAds == null || carouselAds.isEmpty()) {
            throw new BidsNotFoundException("Bids not found");
        }

        var bids = carouselAds.stream().map(ads -> new CurrentBid(
                ads.getPosition(),
                                ads.getNmId(),
                                ads.getPosition(),
                                0,
                                ads.getCpm(),
                                0,
                                ads.getSubjectId()
                        )
                )
                .toList();
        var result = new CarouselBids(bids, itemNumber);
        // TODO использовать эвенты
        addBidRequestToHistory.execute(
                new RequestBids(AdsType.CAROUSEL, itemNumber, result)
        );
        return result;
    }
}
