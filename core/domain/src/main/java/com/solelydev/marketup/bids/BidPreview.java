package com.solelydev.marketup.bids;

import lombok.Value;

@Value
public class BidPreview {
  Integer cpm;
  Integer itemNumber;
  Integer rank;
  String imgLink;
}
