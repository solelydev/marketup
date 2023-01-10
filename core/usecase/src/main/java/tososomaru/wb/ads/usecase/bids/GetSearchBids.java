package tososomaru.wb.ads.usecase.bids;

import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import lombok.Getter;
import tososomaru.wb.ads.bids.SearchBids;

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
