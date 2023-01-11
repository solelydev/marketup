package com.solelydev.marketup.usecase.bids.history.impl;

import com.solelydev.marketup.bids.RequestBids;
import com.solelydev.marketup.bids.RequestBidsPreview;
import com.solelydev.marketup.usecase.bids.history.BidRequestsHistoryExtractor;
import com.solelydev.marketup.usecase.bids.history.GetTop5BidRequestHistory;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetTop5BidRequestHistoryUseCase implements GetTop5BidRequestHistory {
  private final BidRequestsHistoryExtractor bidRequestsHistoryExtractor;

  @Override
  public List<RequestBidsPreview> execute() {
    return bidRequestsHistoryExtractor.getTop5().stream().map(RequestBids::toPreview).toList();
  }
}
