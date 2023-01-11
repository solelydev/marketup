package tososomaru.wb.ads.bids;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Value;
import tososomaru.wb.ads.common.AdsType;

@EqualsAndHashCode(callSuper = true)
@Value
public class CarouselBids extends BaseBids {
  public CarouselBids(List<CurrentBid> bids, String request) {
    super(bids, request, AdsType.CAROUSEL);
  }
}
