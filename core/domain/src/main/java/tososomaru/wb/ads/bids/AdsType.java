package tososomaru.wb.ads.bids;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AdsType {
    SEARCH("search"),
    CATEGORY("category"),
    CAROUSEL("carousel");

    private final String value;
}
