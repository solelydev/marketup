package tososomaru.wb.ads.usecase.bids.history;

import io.vavr.control.Either;
import tososomaru.wb.ads.bids.RequestBids;

public interface GetRequestBidsFromHistoryById {
    Either<GetRequestBidsFromHistoryByIdError, RequestBids> execute(String id);

    abstract sealed class GetRequestBidsFromHistoryByIdError {

        public static final class NotFound extends GetRequestBidsFromHistoryByIdError {}
    }
}
