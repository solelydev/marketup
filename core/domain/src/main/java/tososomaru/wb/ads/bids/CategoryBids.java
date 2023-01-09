package tososomaru.wb.ads.bids;

import lombok.EqualsAndHashCode;
import lombok.Value;
import tososomaru.wb.ads.common.AdsType;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Value
public class CategoryBids extends BaseBids {
    Integer minCpm;

    public CategoryBids(List<CurrentBid> bids, String request, Integer minCpm) {
        super(bids, request, AdsType.CATEGORY);
        this.minCpm = minCpm;
    }
}
