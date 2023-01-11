package tososomaru.wb.ads.usecase.bids.history;

import io.vavr.control.Option;
import java.util.List;
import java.util.UUID;
import tososomaru.wb.ads.bids.RequestBids;

public interface BidRequestsHistoryExtractor {
  List<RequestBids> getAll();

  List<RequestBids> getTop5();

  Option<RequestBids> getById(UUID id);
}
