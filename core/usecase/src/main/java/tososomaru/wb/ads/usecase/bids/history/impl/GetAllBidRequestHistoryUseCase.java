package tososomaru.wb.ads.usecase.bids.history.impl;

import lombok.AllArgsConstructor;
import tososomaru.wb.ads.bids.RequestBids;
import tososomaru.wb.ads.bids.RequestBidsPreview;
import tososomaru.wb.ads.usecase.bids.history.BidRequestsHistoryExtractor;
import tososomaru.wb.ads.usecase.bids.history.GetAllBidRequestHistory;

import java.util.List;

@AllArgsConstructor

public class GetAllBidRequestHistoryUseCase implements GetAllBidRequestHistory {
    private final BidRequestsHistoryExtractor bidRequestsHistoryExtractor;
    @Override
    public List<RequestBidsPreview> execute() {
        return bidRequestsHistoryExtractor.getAll().stream()
                .map(RequestBids::toPreview)
                .toList();
    }
}
