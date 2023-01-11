package tososomaru.wb.ads.usecase.bids.history.impl;

import io.vavr.control.Either;
import java.util.UUID;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.bids.RequestBids;
import tososomaru.wb.ads.usecase.bids.history.BidRequestsHistoryExtractor;
import tososomaru.wb.ads.usecase.bids.history.GetRequestBidsFromHistoryById;

@AllArgsConstructor
public class GetRequestBidsFromHistoryByIdUseCase implements GetRequestBidsFromHistoryById {
  private final BidRequestsHistoryExtractor bidRequestsHistoryExtractor;

  @Override
  public Either<GetRequestBidsFromHistoryByIdError, RequestBids> execute(String id) {
    return bidRequestsHistoryExtractor
        .getById(UUID.fromString(id))
        .fold(() -> Either.left(new GetRequestBidsFromHistoryByIdError.NotFound()), Either::right);
  }
}
