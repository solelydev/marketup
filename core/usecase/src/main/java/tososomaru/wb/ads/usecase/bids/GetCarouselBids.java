package tososomaru.wb.ads.usecase.bids;

import io.vavr.control.Either;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import tososomaru.wb.ads.bids.CarouselBids;

public interface GetCarouselBids {
    Either<GetCarouselBidsError, CarouselBids> execute(String itemNumber);

    @RequiredArgsConstructor
    @Getter
    abstract sealed class GetCarouselBidsError {

        private final String message;

        public static final class CreateSKU extends GetCarouselBidsError {
            public CreateSKU(String message) {
                super(message);
            }
        }

        public static final class BidsNotFound extends GetCarouselBidsError {
            public BidsNotFound() {
                super("Bids not found");
            }
        }
    }

}
