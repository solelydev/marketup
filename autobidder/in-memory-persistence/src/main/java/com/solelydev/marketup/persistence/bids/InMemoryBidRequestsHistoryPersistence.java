package com.solelydev.marketup.persistence.bids;

import com.solelydev.marketup.bids.RequestBids;
import com.solelydev.marketup.usecase.bids.history.BidRequestsHistoryExtractor;
import com.solelydev.marketup.usecase.bids.history.BidRequestsHistorySaver;
import io.vavr.control.Option;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class InMemoryBidRequestsHistoryPersistence
    implements BidRequestsHistorySaver, BidRequestsHistoryExtractor {

  List<RequestBids> bidRequests = new ArrayList<>();

  @Override
  public List<RequestBids> getAll() {
    return bidRequests;
  }

  @Override
  public List<RequestBids> getTop5() {
    return bidRequests.stream()
        .sorted(Comparator.comparing(RequestBids::getCreatedAt))
        .limit(5)
        .toList();
  }

  @Override
  public Option<RequestBids> getById(UUID id) {
    return Option.ofOptional(
        bidRequests.stream().filter(bid -> bid.getId().equals(id)).findFirst());
  }

  @Override
  public RequestBids save(RequestBids bidRequest) {
    bidRequests.add(bidRequest);
    return bidRequest;
  }
}
