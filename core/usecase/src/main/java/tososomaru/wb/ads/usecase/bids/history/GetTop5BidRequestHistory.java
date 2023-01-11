package tososomaru.wb.ads.usecase.bids.history;

import java.util.List;
import tososomaru.wb.ads.bids.RequestBidsPreview;

public interface GetTop5BidRequestHistory {
  List<RequestBidsPreview> execute();
}
