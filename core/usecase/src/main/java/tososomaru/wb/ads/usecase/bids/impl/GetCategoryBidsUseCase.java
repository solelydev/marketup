package tososomaru.wb.ads.usecase.bids.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.usecase.bids.BidsNotFoundException;
import tososomaru.wb.ads.wbapi.WbApi;
import tososomaru.wb.ads.bids.CategoryBids;
import tososomaru.wb.ads.bids.RequestBids;
import tososomaru.wb.ads.bids.AdsType;
import tososomaru.wb.ads.usecase.bids.history.AddBidRequestToHistory;
import tososomaru.wb.ads.usecase.bids.CategoryAdsToBidsMapper;
import tososomaru.wb.ads.usecase.bids.GetCategoryBids;

import java.net.URI;

@AllArgsConstructor
@Component
public class GetCategoryBidsUseCase implements GetCategoryBids {

    private final CategoryAdsToBidsMapper categoryAdsToBidsMapper;
    private final AddBidRequestToHistory addBidRequestToHistory;
    private final WbApi wbApi;

    @Override
    public CategoryBids execute(String menuId) {
        Integer menuIdInt;
        try {
            var uri = URI.create(menuId);
            var path = uri.getPath();
            var splitPath = path.split("/");
            var menu = wbApi.getMainMenu();
            if

        } catch (IllegalArgumentException ignored) {
            menuIdInt = Integer.valueOf(menuId);
        }
        // TODO check

        var catalogAds = wbApi.getCategoryAds(menuIdInt);

        if (catalogAds.getAdverts() == null || catalogAds.getAdverts().isEmpty()) {
            throw new BidsNotFoundException("Bids not found");
        }

        var bidsResultBuilder = CategoryBids.builder()
                .request(menuId);

        bidsResultBuilder.minCpm(catalogAds.getMinCPM());

        bidsResultBuilder.bids(
                categoryAdsToBidsMapper.execute(catalogAds)
        );
        var result = bidsResultBuilder.build();
        addBidRequestToHistory.execute(
                new RequestBids(AdsType.CATEGORY, menuId.toString(), result)
        );
        return result;
    }
}
