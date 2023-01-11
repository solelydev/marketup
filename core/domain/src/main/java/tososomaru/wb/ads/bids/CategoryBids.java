package tososomaru.wb.ads.bids;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Value;
import tososomaru.wb.ads.common.AdsType;

@EqualsAndHashCode(callSuper = true)
@Value
public class CategoryBids extends BaseBids {
  Integer minCpm;

  public CategoryBids(List<CurrentBid> bids, String request, Integer minCpm) {
    super(bids, request, AdsType.CATEGORY);
    this.minCpm = minCpm;
  }
}
