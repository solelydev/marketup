package tososomaru.wb.ads.bids;

import lombok.Value;

import java.util.List;

@Value
public class CarouselBids implements Bids {
    List<CurrentBid> bids;
    String request;
}
