package tososomaru.wb.ads.usecase.bids.history.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.bids.RequestBids;
import tososomaru.wb.ads.usecase.bids.history.AddBidRequestToHistory;
import tososomaru.wb.ads.usecase.bids.history.BidRequestsHistorySaver;

@AllArgsConstructor
@Component
public class AddBidRequestToHistoryUseCase implements AddBidRequestToHistory {

    private final BidRequestsHistorySaver bidRequestsHistorySaver;

    @Override
    public void execute(RequestBids request) {
        bidRequestsHistorySaver.save(request);
    }
}
