package tososomaru.wb.ads.usecase.bids.history.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.bids.RequestBids;
import tososomaru.wb.ads.bids.RequestBidsPreview;
import tososomaru.wb.ads.usecase.bids.history.BidRequestsHistoryExtractor;
import tososomaru.wb.ads.usecase.bids.history.GetTop5BidRequestHistory;

@AllArgsConstructor
public class GetTop5BidRequestHistoryUseCase implements GetTop5BidRequestHistory {
  private final BidRequestsHistoryExtractor bidRequestsHistoryExtractor;

  @Override
  public List<RequestBidsPreview> execute() {
    return bidRequestsHistoryExtractor.getTop5().stream().map(RequestBids::toPreview).toList();
  }
}
