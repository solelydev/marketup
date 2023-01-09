package tososomaru.wb.ads.usecase.bids.history;

import tososomaru.wb.ads.bids.RequestBidsPreview;

import java.util.List;

public interface GetAllBidRequestHistory {
    // TODO добавить пагинацию
    List<RequestBidsPreview> execute();
}
