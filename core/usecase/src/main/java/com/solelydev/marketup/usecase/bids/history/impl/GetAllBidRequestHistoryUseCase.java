package com.solelydev.marketup.usecase.bids.history.impl;

import com.solelydev.marketup.bids.RequestBids;
import com.solelydev.marketup.bids.RequestBidsPreview;
import com.solelydev.marketup.usecase.bids.history.BidRequestsHistoryExtractor;
import com.solelydev.marketup.usecase.bids.history.GetAllBidRequestHistory;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAllBidRequestHistoryUseCase implements GetAllBidRequestHistory {
  private final BidRequestsHistoryExtractor bidRequestsHistoryExtractor;

  @Override
  public List<RequestBidsPreview> execute() {
    return bidRequestsHistoryExtractor.getAll().stream().map(RequestBids::toPreview).toList();
  }
}
