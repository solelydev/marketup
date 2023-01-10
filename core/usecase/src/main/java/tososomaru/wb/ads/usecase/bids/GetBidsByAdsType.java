package tososomaru.wb.ads.usecase.bids;

import io.vavr.control.Either;
import tososomaru.wb.ads.bids.Bids;

public interface GetBidsByAdsType {
    Either<?, Bids> execute(String request, String adsType);
}
