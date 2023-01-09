package tososomaru.wb.ads.usecase.bids;

import tososomaru.wb.ads.bids.Bids;

public interface GetBidsByAdsType {
    Bids execute(String request, String adsType);
}
