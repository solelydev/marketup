package tososomaru.wb.ads.usecase.bids.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.bids.SearchBids;
import tososomaru.wb.ads.usecase.bids.BidsNotFoundException;
import tososomaru.wb.ads.usecase.bids.GetSearchBids;
import tososomaru.wb.ads.usecase.bids.SearchAdsToBidsMapper;
import tososomaru.wb.ads.wbapi.WbApi;

import java.net.URI;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class GetSearchBidsUseCase implements GetSearchBids {

    private final WbApi wbApi;
    private final SearchAdsToBidsMapper catalogAdsToBidCatalogResultMapper;

    public SearchBids execute(String keywordOrUrl) {
        if (keywordOrUrl == null || keywordOrUrl.equals("")) {
            throw new InvalidKeyword("keyword can not be null or empty");
        }
        String keyword;
        try {
            keyword = extractKeywordFromUrl(URI.create(keywordOrUrl))
                    .orElseThrow(() -> new RuntimeException("incorrect url"));

        } catch (IllegalArgumentException ignored) {
            keyword = keywordOrUrl;
        }

        var catalogAds = wbApi.getSearchAds(keyword);

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

    private Optional<String> extractKeywordFromUrl(URI url) {
        return Stream.of(url.getQuery().split("&"))
                .map(queryPart -> queryPart.split("="))
                .filter(q -> Objects.equals(q[0], "search"))
                .map(q -> q[1])
                .findFirst();
    }
}
