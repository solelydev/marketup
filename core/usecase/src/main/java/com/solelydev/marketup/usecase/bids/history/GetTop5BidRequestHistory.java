package com.solelydev.marketup.usecase.bids.history;

import com.solelydev.marketup.bids.RequestBidsPreview;
import java.util.List;

public interface GetTop5BidRequestHistory {
  List<RequestBidsPreview> execute();
}
