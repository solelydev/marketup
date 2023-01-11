package tososomaru.wb.ads.bids;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.Value;
import tososomaru.wb.ads.common.AdsType;

@Value
public class RequestBidsPreview {
  UUID id;
  Date createdAt;
  AdsType type;
  String request;
  List<BidPreview> bids;
}
