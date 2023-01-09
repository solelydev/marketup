package tososomaru.wb.ads.usecase.bids.history;

import tososomaru.wb.ads.bids.RequestBids;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BidRequestsHistoryExtractor {
    List<RequestBids> getAll();
    List<RequestBids> getTop5();
    Optional<RequestBids> getById(UUID id);
}
