package tososomaru.wb.ads.usecase.bids.history;

import tososomaru.wb.ads.bids.RequestBids;

public interface GetRequestBidsFromHistoryById {
    RequestBids execute(String id);
}
