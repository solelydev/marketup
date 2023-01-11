package com.solelydev.marketup.usecase.bids.history;

import com.solelydev.marketup.bids.RequestBids;
import io.vavr.control.Option;
import java.util.List;
import java.util.UUID;

public interface BidRequestsHistoryExtractor {
  List<RequestBids> getAll();

  List<RequestBids> getTop5();

  Option<RequestBids> getById(UUID id);
}
