package com.solelydev.marketup.bids;

import com.solelydev.marketup.common.AdsType;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class CategoryBids extends BaseBids {
  Integer minCpm;

  public CategoryBids(List<CurrentBid> bids, String request, Integer minCpm) {
    super(bids, request, AdsType.CATEGORY);
    this.minCpm = minCpm;
  }
}
