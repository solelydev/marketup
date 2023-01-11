package com.solelydev.marketup.bids;

import com.solelydev.marketup.common.AdsType;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class CarouselBids extends BaseBids {
  public CarouselBids(List<CurrentBid> bids, String request) {
    super(bids, request, AdsType.CAROUSEL);
  }
}
