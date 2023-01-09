package tososomaru.wb.ads.bids;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class CategoryBids implements Bids {
    List<CurrentBid> bids;
    Integer minCpm;
    String request;
}
