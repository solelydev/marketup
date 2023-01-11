package com.solelydev.marketup.usecase.bids.history.impl;

import com.solelydev.marketup.bids.Bids;
import com.solelydev.marketup.usecase.bids.GetBidsByAdsType;
import com.solelydev.marketup.usecase.bids.history.GetRequestBidsFromHistoryById;
import com.solelydev.marketup.usecase.bids.history.UpdateBidsFromHistory;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateBidsFromHistoryUseCase implements UpdateBidsFromHistory {
  private final GetBidsByAdsType getBidsByAdsType;
  private final GetRequestBidsFromHistoryById getRequestBidsFromHistoryById;

  @Override
  public Either<UpdateBidsFromHistory.UpdateBidsFromHistoryError, Bids> execute(String id) {
    return getRequestBidsFromHistoryById
        .execute(id)
        .bimap(
            error ->
                switch (error) {
                  case GetRequestBidsFromHistoryById.GetRequestBidsFromHistoryByIdError.NotFound
                  ignored -> new UpdateBidsFromHistoryError.BidsNotFound();
                },
            req -> getBidsByAdsType.execute(req.getRequest(), req.getType().toString()).get());
  }
}
