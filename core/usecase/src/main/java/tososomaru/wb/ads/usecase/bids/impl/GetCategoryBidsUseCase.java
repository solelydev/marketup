package tososomaru.wb.ads.usecase.bids.impl;

import io.vavr.control.Either;
import java.net.URI;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.bids.CategoryBids;
import tososomaru.wb.ads.usecase.bids.CategoryAdsToBidsMapper;
import tososomaru.wb.ads.usecase.bids.GetCategoryBids;
import tososomaru.wb.ads.wbapi.WbApi;
import tososomaru.wb.ads.wbapi.WbMenuIdStore;

@AllArgsConstructor
public class GetCategoryBidsUseCase implements GetCategoryBids {

  private final CategoryAdsToBidsMapper categoryAdsToBidsMapper;
  private final WbApi wbApi;
  private final WbMenuIdStore wbMenuIdStore;

  @Override
  public Either<GetCategoryBidsError, CategoryBids> execute(String menuIdOrMenuUrl) {
    Integer menuIdInt;
    try {
      String path = URI.create(menuIdOrMenuUrl).getPath();
      menuIdInt =
          wbMenuIdStore.getMenuId(path).orElseThrow(() -> new RuntimeException("menu not  found"));
    } catch (IllegalArgumentException ignored) {
      menuIdInt = Integer.valueOf(menuIdOrMenuUrl);
    } catch (Exception e) {
      return Either.left(new GetCategoryBidsError.CreateMenuId(e.getMessage()));
    }

    var catalogAds = wbApi.getCategoryAds(menuIdInt);

    if (catalogAds.getAdverts() == null || catalogAds.getAdverts().isEmpty()) {
      return Either.left(new GetCategoryBidsError.BidsNotFound());
    }

    var bids = categoryAdsToBidsMapper.execute(catalogAds);
    return Either.right(new CategoryBids(bids, menuIdOrMenuUrl, catalogAds.getMinCPM()));
  }
}
