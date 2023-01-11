package com.solelydev.marketup.usecase.bids.history;

import com.solelydev.marketup.bids.RequestBids;

public interface AddBidRequestToHistory {
  void execute(RequestBids request);
}
