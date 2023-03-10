package com.solelydev.marketup.rest.bids;

import com.solelydev.marketup.bids.Bids;
import com.solelydev.marketup.bids.RequestBids;
import com.solelydev.marketup.bids.RequestBidsPreview;
import com.solelydev.marketup.usecase.bids.history.GetAllBidRequestHistory;
import com.solelydev.marketup.usecase.bids.history.GetRequestBidsFromHistoryById;
import com.solelydev.marketup.usecase.bids.history.GetTop5BidRequestHistory;
import com.solelydev.marketup.usecase.bids.history.UpdateBidsFromHistory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bids/history")
@RequiredArgsConstructor
@Tag(name = "История запросов ставок", description = "API истории запросов ставок")
public class BidsHistoryController {
  private final GetAllBidRequestHistory getAllBidRequestHistory;
  // TODO просто топ, не 5
  private final GetTop5BidRequestHistory getTop5BidRequestHistory;
  private final UpdateBidsFromHistory updateBidsFromHistory;
  private final GetRequestBidsFromHistoryById getRequestBidsFromHistoryById;

  /**
   * Получить запрос ставок
   *
   * @param id ID запроса
   * @return {@link RequestBids}
   */
  @GetMapping(path = "/id")
  public ResponseEntity<RequestBids> getRequestBids(@PathVariable String id) {
    return getRequestBidsFromHistoryById
        .execute(id)
        .fold(
            error ->
                switch (error) {
                  case GetRequestBidsFromHistoryById.GetRequestBidsFromHistoryByIdError.NotFound
                  e -> ResponseEntity.notFound().build();
                },
            ResponseEntity::ok);
  }

  @Operation(summary = "Получить всю историю")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Список превью запросов ставок",
            content =
                @Content(
                    mediaType = "application/json",
                    array =
                        @ArraySchema(schema = @Schema(implementation = RequestBidsPreview.class))))
      })
  @GetMapping
  public ResponseEntity<List<RequestBidsPreview>> getAllHistory() {
    return ResponseEntity.ok(getAllBidRequestHistory.execute());
  }

  @Operation(summary = "Получить топ запросов по дате")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Список превью запросов ставок",
            content =
                @Content(
                    mediaType = "application/json",
                    array =
                        @ArraySchema(schema = @Schema(implementation = RequestBidsPreview.class))))
      })
  @GetMapping("/top")
  public ResponseEntity<List<RequestBidsPreview>> getTopHistory() {
    return ResponseEntity.ok(getTop5BidRequestHistory.execute());
  }

  @Operation(summary = "Получить актуальные ставки на основе запроса из истории")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "202",
            description = "Актуальная ставка ",
            content =
                @Content(
                    mediaType = "application/json",
                    array =
                        @ArraySchema(schema = @Schema(implementation = RequestBidsPreview.class))))
      })
  @PostMapping("/{requestId}/update")
  public ResponseEntity<Bids> getActualBidsFromRequestInHistory(
      @Parameter(
              name = "requestId",
              description = "ID запроса из истории",
              example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
          @PathVariable
          String requestId) {
    return updateBidsFromHistory
        .execute(requestId)
        .fold(
            error ->
                switch (error) {
                  case UpdateBidsFromHistory.UpdateBidsFromHistoryError.BidsNotFound
                  ignored -> ResponseEntity.notFound().build();
                },
            bids -> ResponseEntity.accepted().body(bids));
  }
}
