package com.solelydev.marketup.bids;

import com.solelydev.marketup.common.AdsType;
import java.util.List;

public interface Bids {
  List<CurrentBid> getBids();

  String getRequest();

  AdsType getAdsType();
}
