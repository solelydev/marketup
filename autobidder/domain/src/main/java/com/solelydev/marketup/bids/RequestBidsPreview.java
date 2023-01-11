package com.solelydev.marketup.bids;

import com.solelydev.marketup.common.AdsType;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.Value;

@Value
public class RequestBidsPreview {
  UUID id;
  Date createdAt;
  AdsType type;
  String request;
  List<BidPreview> bids;
}
