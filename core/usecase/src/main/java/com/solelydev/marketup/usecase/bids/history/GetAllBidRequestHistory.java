package com.solelydev.marketup.usecase.bids.history;

import com.solelydev.marketup.bids.RequestBidsPreview;
import java.util.List;

public interface GetAllBidRequestHistory {
  // TODO добавить пагинацию
  List<RequestBidsPreview> execute();
}
