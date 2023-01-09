package tososomaru.wb.ads.bids;

import lombok.Value;
import tososomaru.wb.ads.bids.AdsType;
import tososomaru.wb.ads.bids.BidPreview;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Value
public class RequestBidsPreview {
    UUID id;
    Date createdAt;
    AdsType type;
    String request;
    List<BidPreview> bids;
}
