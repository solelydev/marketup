package tososomaru.wb.ads.usecase.bids.impl;

import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.bids.Bids;
import tososomaru.wb.ads.bids.RequestBids;
import tososomaru.wb.ads.common.AdsType;
import tososomaru.wb.ads.usecase.bids.GetBidsByAdsType;
import tososomaru.wb.ads.usecase.bids.GetCarouselBids;
import tososomaru.wb.ads.usecase.bids.GetCategoryBids;
import tososomaru.wb.ads.usecase.bids.GetSearchBids;
import tososomaru.wb.ads.usecase.bids.history.AddBidRequestToHistory;

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
        var bids = switch (adsTypeE) {
            case SEARCH -> getSearchBids.execute(request);
            case CATEGORY -> getCategoryBids.execute(request);
            case CAROUSEL -> getCarouselBids.execute(request);
        };

        return bids
                .peek(b -> addBidRequestToHistory.execute(new RequestBids(request, b)))
                .map(Bids.class::cast);
    }
}
