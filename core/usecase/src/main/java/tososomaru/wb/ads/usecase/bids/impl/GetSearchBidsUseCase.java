package tososomaru.wb.ads.usecase.bids.impl;

import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import tososomaru.wb.ads.bids.SearchBids;
import tososomaru.wb.ads.common.types.SearchKeyword;
import tososomaru.wb.ads.usecase.bids.GetSearchBids;
import tososomaru.wb.ads.usecase.bids.SearchAdsToBidsMapper;
import tososomaru.wb.ads.wbapi.WbApi;


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

        //TODO получить имя категории по id
        var priorityCategories = catalogAds.getPrioritySubjects()
                .stream()
                .map(Object::toString).toList();

        var bids = catalogAdsToBidCatalogResultMapper.execute(catalogAds);
        return Either.right(
                new SearchBids(bids, keywordOrUrl, priorityCategories, catalogAds.getMinCPM())
        );
    }
}
