package tososomaru.wb.ads.usecase.bids.history;

import tososomaru.wb.ads.bids.RequestBids;

public interface BidRequestsHistorySaver {

  RequestBids save(RequestBids bidRequest);
}
