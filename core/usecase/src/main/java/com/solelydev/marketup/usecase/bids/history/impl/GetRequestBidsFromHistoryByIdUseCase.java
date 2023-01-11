package com.solelydev.marketup.usecase.bids.history.impl;

import com.solelydev.marketup.bids.RequestBids;
import com.solelydev.marketup.usecase.bids.history.BidRequestsHistoryExtractor;
import com.solelydev.marketup.usecase.bids.history.GetRequestBidsFromHistoryById;
import io.vavr.control.Either;
import java.util.UUID;
import lombok.AllArgsConstructor;

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
