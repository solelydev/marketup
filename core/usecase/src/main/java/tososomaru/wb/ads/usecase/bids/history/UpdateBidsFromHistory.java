package tososomaru.wb.ads.usecase.bids.history;

import tososomaru.wb.ads.bids.Bids;

public interface UpdateBidsFromHistory {
    Bids execute(String id);
}
