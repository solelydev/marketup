package com.solelydev.marketup.usecase.bids;

import com.solelydev.marketup.bids.SearchBids;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import lombok.Getter;

public interface GetSearchBids {
  Either<GetSearchBidsError, SearchBids> execute(String keyword);

  @AllArgsConstructor
  @Getter
  abstract sealed class GetSearchBidsError {
    private final String message;

    public static final class CreateKeyword extends GetSearchBidsError {
      public CreateKeyword(String message) {
        super(message);
      }
    }

    public static final class BidsNotFound extends GetSearchBidsError {
      public BidsNotFound() {
        super("bids not found");
      }
    }
  }
}
