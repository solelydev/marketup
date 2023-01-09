package tososomaru.wb.ads.usecase.bids.history.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.bids.Bids;
import tososomaru.wb.ads.usecase.bids.GetBidsByAdsType;
import tososomaru.wb.ads.usecase.bids.history.BidRequestsHistoryExtractor;
import tososomaru.wb.ads.usecase.bids.history.UpdateBidsFromHistory;

import java.util.UUID;

@AllArgsConstructor
@Component
public class UpdateBidsFromHistoryUseCase implements UpdateBidsFromHistory {
    private final BidRequestsHistoryExtractor bidRequestsHistoryExtractor;
    private final GetBidsByAdsType getBidsByAdsType;

    @Override
    public Bids execute(String id) {
        // TODO валидация
        UUID uuid = UUID.fromString(id);
        // TODO exception -> either
        return bidRequestsHistoryExtractor.getById(uuid)
                .map(request -> getBidsByAdsType.execute(request.getRequest(), request.getType().toString()))
                .orElseThrow(() -> new RuntimeException("Not found"))
                ;
    }
}
