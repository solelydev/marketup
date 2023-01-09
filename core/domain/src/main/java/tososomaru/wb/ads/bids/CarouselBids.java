package tososomaru.wb.ads.bids;

import lombok.EqualsAndHashCode;
import lombok.Value;
import tososomaru.wb.ads.common.AdsType;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Value
public class CarouselBids extends BaseBids {
    public CarouselBids(List<CurrentBid> bids, String request) {
        super(bids, request, AdsType.CAROUSEL);
    }
}
