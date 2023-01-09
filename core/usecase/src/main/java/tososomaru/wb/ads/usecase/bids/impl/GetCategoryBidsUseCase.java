package tososomaru.wb.ads.usecase.bids.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import tososomaru.wb.ads.bids.CategoryBids;
import tososomaru.wb.ads.usecase.bids.BidsNotFoundException;
import tososomaru.wb.ads.usecase.bids.CategoryAdsToBidsMapper;
import tososomaru.wb.ads.usecase.bids.GetCategoryBids;
import tososomaru.wb.ads.wbapi.WbApi;
import tososomaru.wb.ads.wbapi.WbMenuIdStore;

import java.net.URI;

@AllArgsConstructor
@Component
public class GetCategoryBidsUseCase implements GetCategoryBids {

    private final CategoryAdsToBidsMapper categoryAdsToBidsMapper;
    private final WbApi wbApi;
    private final WbMenuIdStore wbMenuIdStore;

    @Override
    public CategoryBids execute(String menuIdOrMenuUrl) {
        Integer menuIdInt;
        try {
            String path = URI.create(menuIdOrMenuUrl).getPath();
            menuIdInt = wbMenuIdStore.getMenuId(path)
                    .orElseThrow(() -> new RuntimeException("menu not  found"));
        } catch (IllegalArgumentException ignored) {
            menuIdInt = Integer.valueOf(menuIdOrMenuUrl);
        }

        var catalogAds = wbApi.getCategoryAds(menuIdInt);

        if (catalogAds.getAdverts() == null || catalogAds.getAdverts().isEmpty()) {
            throw new BidsNotFoundException("Bids not found");
        }

        var bids = categoryAdsToBidsMapper.execute(catalogAds);
        return new CategoryBids(bids, menuIdOrMenuUrl, catalogAds.getMinCPM());
    }

}
