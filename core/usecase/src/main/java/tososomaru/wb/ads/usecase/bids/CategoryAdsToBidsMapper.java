package tososomaru.wb.ads.usecase.bids;

import org.springframework.stereotype.Component;
import tososomaru.wb.ads.wbapi.model.CategoryAdsResponse;
import tososomaru.wb.ads.bids.CurrentBid;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryAdsToBidsMapper {
    public List<CurrentBid> execute(CategoryAdsResponse categoryAds) {
        var currentBids = new ArrayList<CurrentBid>();

        var adverts = categoryAds.getAdverts();

        for (int i = 0; i < adverts.size(); i++) {
            var advert = adverts.get(i);
            var pageNumber = i / 10;
            // TODO сортировать страницы
            var page = categoryAds.getPages().get(pageNumber);
            var position = page.getPositions().get(i % 10);
            // TODO найти способ получать deliveryTime
            // TODO найти способ получать категорию товара
            var currentBid = new CurrentBid(
                    i,
                    advert.getId(),
                    position,
                    pageNumber,
                    advert.getCpm(),
                    0,
                    0
            );
            currentBids.add(currentBid);
        }
        return currentBids;
    }
}
