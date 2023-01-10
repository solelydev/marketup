package tososomaru.wb.ads.usecase.bids.history.impl;

import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.bids.Bids;
import tososomaru.wb.ads.usecase.bids.GetBidsByAdsType;
import tososomaru.wb.ads.usecase.bids.history.GetRequestBidsFromHistoryById;
import tososomaru.wb.ads.usecase.bids.history.UpdateBidsFromHistory;

@AllArgsConstructor

public class UpdateBidsFromHistoryUseCase implements UpdateBidsFromHistory {
    private final GetBidsByAdsType getBidsByAdsType;
    private final GetRequestBidsFromHistoryById getRequestBidsFromHistoryById;

    @Override
    public Either<UpdateBidsFromHistory.UpdateBidsFromHistoryError, Bids> execute(String id) {
        return getRequestBidsFromHistoryById.execute(id)
                .bimap(
                        error -> switch (error) {
                            case GetRequestBidsFromHistoryById.GetRequestBidsFromHistoryByIdError.NotFound ignored
                                    -> new UpdateBidsFromHistoryError.BidsNotFound();
                        },
                        req -> getBidsByAdsType.execute(
                                req.getRequest(),
                                req.getType().toString()
                        ).get()
                );
    }
}
