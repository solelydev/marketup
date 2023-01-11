package tososomaru.wb.ads.usecase.bids.history;

import java.util.List;
import tososomaru.wb.ads.bids.RequestBidsPreview;

public interface GetAllBidRequestHistory {
  // TODO добавить пагинацию
  List<RequestBidsPreview> execute();
}
