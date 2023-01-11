package com.solelydev.marketup.usecase.bids.impl;

import com.solelydev.marketup.bids.CategoryBids;
import com.solelydev.marketup.usecase.bids.CategoryAdsToBidsMapper;
import com.solelydev.marketup.usecase.bids.GetCategoryBids;
import com.solelydev.marketup.wbapi.WbApi;
import com.solelydev.marketup.wbapi.WbMenuIdStore;
import io.vavr.control.Either;
import java.net.URI;
import lombok.AllArgsConstructor;

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
