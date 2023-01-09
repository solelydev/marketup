package tososomaru.wb.ads.bids;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class SearchBids implements Bids {
    List<CurrentBid> bids;
    List<String> priorityCategories;
    Integer minCpm;
    String request;
}
