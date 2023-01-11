package com.solelydev.marketup.bids;

import com.solelydev.marketup.common.AdsType;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.Value;

@Value
public class RequestBids {
  UUID id;
  Date createdAt;
  AdsType type;
  String request;
  List<CurrentBid> bids;

  public RequestBids(String request, Bids bidResult) {
    this.id = UUID.randomUUID();
    this.createdAt = new Date();
    this.type = bidResult.getAdsType();
    this.request = request;
    this.bids = bidResult.getBids();
  }

  public RequestBidsPreview toPreview() {
    var previewBids = bids.stream().limit(5).map(CurrentBid::toPreview).toList();
    return new RequestBidsPreview(id, createdAt, type, request, previewBids);
  }
}
