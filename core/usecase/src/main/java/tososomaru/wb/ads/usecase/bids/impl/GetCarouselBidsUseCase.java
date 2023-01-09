package tososomaru.wb.ads.usecase.bids.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.bids.CarouselBids;
import tososomaru.wb.ads.bids.CurrentBid;
import tososomaru.wb.ads.usecase.bids.BidsNotFoundException;
import tososomaru.wb.ads.usecase.bids.GetCarouselBids;
import tososomaru.wb.ads.wbapi.WbApi;

import java.net.URI;

@AllArgsConstructor
@Component
public class GetCarouselBidsUseCase implements GetCarouselBids {

    private final WbApi wbApi;

    @Override
    public CarouselBids execute(String itemNumber) {
        int itemNumberInt;
        try {
            var path = URI.create(itemNumber).getPath();
            itemNumberInt = Integer.parseInt(path.split("/")[1]);
        } catch (Exception ignored) {
            itemNumberInt = Integer.parseInt(itemNumber);
        }
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
        return new CarouselBids(bids, itemNumber);
    }
}
