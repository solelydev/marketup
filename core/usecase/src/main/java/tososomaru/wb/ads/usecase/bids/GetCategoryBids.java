package tososomaru.wb.ads.usecase.bids;

import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import lombok.Getter;
import tososomaru.wb.ads.bids.CategoryBids;

public interface GetCategoryBids {
  Either<GetCategoryBidsError, CategoryBids> execute(String menuId);

  @AllArgsConstructor
  @Getter
  abstract sealed class GetCategoryBidsError {
    private final String message;

    public static final class BidsNotFound extends GetCategoryBidsError {
      public BidsNotFound() {
        super("not found");
      }
    }

    public static final class CreateMenuId extends GetCategoryBidsError {
      public CreateMenuId(String message) {
        super(message);
      }
    }
  }
}
