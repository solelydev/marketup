package tososomaru.wb.ads.usecase.bids;

import tososomaru.wb.ads.bids.CarouselBids;

public interface GetCarouselBids {
    CarouselBids execute(String itemNumber);
}
