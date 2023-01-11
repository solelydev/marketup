package com.solelydev.marketup.usecase.bids.history.impl;

import com.solelydev.marketup.bids.RequestBids;
import com.solelydev.marketup.usecase.bids.history.AddBidRequestToHistory;
import com.solelydev.marketup.usecase.bids.history.BidRequestsHistorySaver;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddBidRequestToHistoryUseCase implements AddBidRequestToHistory {

  private final BidRequestsHistorySaver bidRequestsHistorySaver;

  @Override
  public void execute(RequestBids request) {
    bidRequestsHistorySaver.save(request);
  }
}
