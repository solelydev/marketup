package tososomaru.wb.ads.bids;

import tososomaru.wb.ads.common.AdsType;

import java.util.List;

public interface Bids {
    List<CurrentBid> getBids();

    String getRequest();

    AdsType getAdsType();
}
