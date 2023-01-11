package com.solelydev.marketup.bids;

import com.solelydev.marketup.common.AdsType;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class SearchBids extends BaseBids {
  List<String> priorityCategories;
  Integer minCpm;

  public SearchBids(
      List<CurrentBid> bids, String request, List<String> priorityCategories, Integer minCpm) {
    super(bids, request, AdsType.SEARCH);
    this.priorityCategories = priorityCategories;
    this.minCpm = minCpm;
  }
}
