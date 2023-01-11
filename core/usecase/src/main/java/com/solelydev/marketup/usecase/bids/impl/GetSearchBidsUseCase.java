package com.solelydev.marketup.usecase.bids.impl;

import com.solelydev.marketup.bids.SearchBids;
import com.solelydev.marketup.common.types.SearchKeyword;
import com.solelydev.marketup.usecase.bids.GetSearchBids;
import com.solelydev.marketup.usecase.bids.SearchAdsToBidsMapper;
import com.solelydev.marketup.wbapi.WbApi;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetSearchBidsUseCase implements GetSearchBids {

  private final WbApi wbApi;
  private final SearchAdsToBidsMapper catalogAdsToBidCatalogResultMapper;

  public Either<GetSearchBidsError, SearchBids> execute(String keywordOrUrl) {
    var keyword = SearchKeyword.create(keywordOrUrl);
    var catalogAds = wbApi.getSearchAds(keyword.getValue());

    var adverts = catalogAds.getAdverts();
    if (adverts == null || adverts.isEmpty()) {
      return Either.left(new GetSearchBidsError.BidsNotFound());
    }

    // TODO получить имя категории по id
    var priorityCategories =
        catalogAds.getPrioritySubjects().stream().map(Object::toString).toList();

    var bids = catalogAdsToBidCatalogResultMapper.execute(catalogAds);
    return Either.right(
        new SearchBids(bids, keywordOrUrl, priorityCategories, catalogAds.getMinCPM()));
  }
}
