package tososomaru.wb.ads.usecase.bids.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.common.AdsType;
import tososomaru.wb.ads.bids.Bids;
import tososomaru.wb.ads.usecase.bids.GetBidsByAdsType;
import tososomaru.wb.ads.usecase.bids.GetCarouselBids;
import tososomaru.wb.ads.usecase.bids.GetCategoryBids;
import tososomaru.wb.ads.usecase.bids.GetSearchBids;

@AllArgsConstructor
@Component
public class GetBidsByAdsTypeUseCase implements GetBidsByAdsType {
    private final GetCarouselBids getCarouselBids;
    private final GetCategoryBids getCategoryBids;
    private final GetSearchBids getSearchBids;

    @Override
    public Bids execute(String request, String adsType) {
        // TODO check enum
        var adsTypeE = AdsType.valueOf(adsType.toUpperCase());
        return switch (adsTypeE) {
            case SEARCH -> getSearchBids.execute(request);
            case CATEGORY -> getCategoryBids.execute(request);
            case CAROUSEL -> getCarouselBids.execute(request);
        };
    }
}
