package tososomaru.wb.ads.usecase.bids.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.bids.SearchBids;
import tososomaru.wb.ads.common.types.SearchKeyword;
import tososomaru.wb.ads.usecase.bids.BidsNotFoundException;
import tososomaru.wb.ads.usecase.bids.GetSearchBids;
import tososomaru.wb.ads.usecase.bids.SearchAdsToBidsMapper;
import tososomaru.wb.ads.wbapi.WbApi;

@Component
@AllArgsConstructor
public class GetSearchBidsUseCase implements GetSearchBids {

    private final WbApi wbApi;
    private final SearchAdsToBidsMapper catalogAdsToBidCatalogResultMapper;

    public SearchBids execute(String keywordOrUrl) {
        var keyword = SearchKeyword.create(keywordOrUrl);
        var catalogAds = wbApi.getSearchAds(keyword.getValue());

        var adverts = catalogAds.getAdverts();
        if (adverts == null || adverts.isEmpty()) {
            throw new BidsNotFoundException("Bids not found");
        }

        //TODO получить имя категории по id
        var priorityCategories = catalogAds.getPrioritySubjects()
                .stream()
                .map(Object::toString).toList();

        var bids = catalogAdsToBidCatalogResultMapper.execute(catalogAds);
        return new SearchBids(bids, keywordOrUrl, priorityCategories, catalogAds.getMinCPM());
    }
}
