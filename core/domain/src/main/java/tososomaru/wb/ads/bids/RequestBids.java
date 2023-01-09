package tososomaru.wb.ads.bids;

import lombok.Value;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Value
// TODO выдывать preview только при получении
public class RequestBids {
    UUID id;
    Date createdAt;
    AdsType type;
    String request;
    List<CurrentBid> bids;

    public RequestBids(AdsType type , String request, Bids bidResult) {
        this.id = UUID.randomUUID();
        this.createdAt = new Date();
        this.type = type;
        this.request = request;
        this.bids = bidResult.getBids();
    }

    public RequestBidsPreview toPreview() {
        var previewBids = bids.stream().limit(5).map(CurrentBid::toPreview).toList();
        return new RequestBidsPreview(id, createdAt, type, request, previewBids);
    }
}
