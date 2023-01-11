package tososomaru.wb.ads.usecase.bids.history;

import io.vavr.control.Either;
import tososomaru.wb.ads.bids.Bids;

public interface UpdateBidsFromHistory {
  Either<UpdateBidsFromHistory.UpdateBidsFromHistoryError, Bids> execute(String id);

  abstract sealed class UpdateBidsFromHistoryError {

    public static final class BidsNotFound extends UpdateBidsFromHistoryError {}
  }
}
