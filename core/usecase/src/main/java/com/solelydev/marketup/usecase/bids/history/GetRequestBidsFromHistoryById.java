package com.solelydev.marketup.usecase.bids.history;

import com.solelydev.marketup.bids.RequestBids;
import io.vavr.control.Either;

public interface GetRequestBidsFromHistoryById {
  Either<GetRequestBidsFromHistoryByIdError, RequestBids> execute(String id);

  abstract sealed class GetRequestBidsFromHistoryByIdError {

    public static final class NotFound extends GetRequestBidsFromHistoryByIdError {}
  }
}
