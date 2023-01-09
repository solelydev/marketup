package tososomaru.wb.ads.usecase.bids.history.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.bids.RequestBids;
import tososomaru.wb.ads.usecase.bids.history.BidRequestsHistoryExtractor;
import tososomaru.wb.ads.usecase.bids.history.GetRequestBidsFromHistoryById;

import java.util.UUID;

@AllArgsConstructor
@Component
public class GetRequestBidsFromHistoryByIdUseCase implements GetRequestBidsFromHistoryById {
    private final BidRequestsHistoryExtractor bidRequestsHistoryExtractor;
    @Override
    public RequestBids execute(String id) {
        return bidRequestsHistoryExtractor.getById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}
