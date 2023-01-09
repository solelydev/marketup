package tososomaru.wb.ads.usecase.bids;

import tososomaru.wb.ads.bids.SearchBids;

public interface GetSearchBids {
    SearchBids execute(String keyword);

    abstract sealed class GetBidsByKeywordException extends RuntimeException {
        protected GetBidsByKeywordException(String message) {
            super(message);
        }
    }

    final class InvalidKeyword extends GetBidsByKeywordException {

        public InvalidKeyword(String message) {
            super(message);
        }
    }

}
