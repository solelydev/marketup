package com.solelydev.marketup.usecase.bids;

import com.solelydev.marketup.bids.Bids;
import io.vavr.control.Either;

public interface GetBidsByAdsType {
  Either<?, Bids> execute(String request, String adsType);
}
