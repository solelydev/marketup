package tososomaru.wb.ads.usecase.bids;

import tososomaru.wb.ads.bids.CategoryBids;

public interface GetCategoryBids {
    CategoryBids execute(String menuId);
}
