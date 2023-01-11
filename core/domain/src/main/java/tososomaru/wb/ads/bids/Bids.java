package tososomaru.wb.ads.bids;

import java.util.List;
import tososomaru.wb.ads.common.AdsType;

public interface Bids {
  List<CurrentBid> getBids();

  String getRequest();

  AdsType getAdsType();
}
