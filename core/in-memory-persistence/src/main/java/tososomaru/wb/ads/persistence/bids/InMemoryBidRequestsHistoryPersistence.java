package tososomaru.wb.ads.persistence.bids;

import io.vavr.control.Option;
import tososomaru.wb.ads.bids.RequestBids;
import tososomaru.wb.ads.usecase.bids.history.BidRequestsHistoryExtractor;
import tososomaru.wb.ads.usecase.bids.history.BidRequestsHistorySaver;

import java.util.*;

public class InMemoryBidRequestsHistoryPersistence implements
        BidRequestsHistorySaver, BidRequestsHistoryExtractor {

    List<RequestBids> bidRequests = new ArrayList<>();

    @Override
    public List<RequestBids> getAll() {
        return bidRequests;
    }

    @Override
    public List<RequestBids> getTop5() {
        return bidRequests.stream()
                .sorted(Comparator.comparing(RequestBids::getCreatedAt))
                .limit(5).toList();
    }

    @Override
    public Option<RequestBids> getById(UUID id) {
        return Option.ofOptional(
                bidRequests.stream().filter(bid -> bid.getId().equals(id)).findFirst()
        );
    }

    @Override
    public RequestBids save(RequestBids bidRequest) {
        bidRequests.add(bidRequest);
        return bidRequest;
    }
}
