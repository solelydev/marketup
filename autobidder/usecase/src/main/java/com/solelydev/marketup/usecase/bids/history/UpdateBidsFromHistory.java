package com.solelydev.marketup.usecase.bids.history;

import com.solelydev.marketup.bids.Bids;
import io.vavr.control.Either;

public interface UpdateBidsFromHistory {
  Either<UpdateBidsFromHistory.UpdateBidsFromHistoryError, Bids> execute(String id);

  abstract sealed class UpdateBidsFromHistoryError {

    public static final class BidsNotFound extends UpdateBidsFromHistoryError {}
  }
}
