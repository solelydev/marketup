package tososomaru.wb.ads.rest.bids;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import tososomaru.wb.ads.bids.*;
import tososomaru.wb.ads.common.AdsType;
import tososomaru.wb.ads.usecase.bids.*;

// TODO переместить контроллер в infrastructure
// TODO добавить историю запросов
@RestController
@RequestMapping(path = "/bids")
@AllArgsConstructor
@Tag(name = "Ставки", description = "API ставок")
public class BidsController {

    private final GetBidsByAdsType getBidsByAdsType;
    private final GetSearchBids getSearchBids;
    private final GetCarouselBids getCarouselBids;
    private final GetCategoryBids getCategoryBids;

    // TODO также принимать ссылку
    @Operation(summary = "Получить ставки")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ставки",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Bids.class)
                            )

                    )
            }
    )
    @PostMapping
    public ResponseEntity<Bids> getBids(
            @Parameter(name = "r", description = "Ключевое слово, артикул или id категории",
                    example = "Телефон")
            @RequestParam String r,
            @Parameter(name = "adsType", description = "Тип рекламы", example = "search",
                    schema = @Schema(implementation = AdsType.class))
            @RequestParam String adsType
    ) {
        return ResponseEntity.ok(
                getBidsByAdsType.execute(r, adsType)
        );
    }

    // TODO также принимать ссылку
    @Operation(summary = "Получить ставки поиска")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ставки поиска",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = SearchBids.class)
                            )

                    )
            }
    )
    @PostMapping("/search")
    public ResponseEntity<SearchBids> getSearchBids(
            @Parameter(name = "keyword", description = "Ключевое слово", example = "Телефон")
            @RequestParam String keyword
    ) {
        return ResponseEntity.ok(
                getSearchBids.execute(keyword)
        );
    }

    // TODO также принимать ссылку
    @Operation(summary = "Получить ставки карточки")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ставки карточки",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CarouselBids.class)
                            )

                    )
            }
    )
    @PostMapping("/carousel")
    public ResponseEntity<?> getCarouselBids(
            @Parameter(name = "itemNumber", description = "Артикул карточки", example = "135485046")
            @RequestParam String itemNumber
    ) {
        return getCarouselBids.execute(itemNumber)
                .fold(
                        e -> switch (e) {
                            case GetCarouselBids.GetCarouselBidsError.CreateSKU a -> ResponseEntity.unprocessableEntity().body(a.getMessage());
                            case GetCarouselBids.GetCarouselBidsError.BidsNotFound ignored -> ResponseEntity.notFound().build();
                        },
                        ResponseEntity::ok
                );
    }

    // TODO также принимать ссылку
    @Operation(summary = "Получить ставки категории")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ставки категории",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CategoryBids.class)
                            )

                    )
            }
    )
    @PostMapping("/category")
    public ResponseEntity<CategoryBids> getCategoryBids(
            @Parameter(name = "menuId",description = "Id категории", example = "8144")
            @RequestParam String menuId
    ) {
        return ResponseEntity.ok(
                getCategoryBids.execute(menuId)
        );
    }

    // TODO переместить обработку ошибок
    // TODO создать единный ответ для ошибок
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<String> handleMissingServletRequestParameterException(MissingServletRequestParameterException msrpe) {
        var parameterName = msrpe.getParameterName();
        return ResponseEntity
                .unprocessableEntity()
                .body(String.format("%s parameter is missing", parameterName));
    }

    @ExceptionHandler(BidsNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<String> handleBidsNotFoundException(BidsNotFoundException bnfe) {
        return ResponseEntity.unprocessableEntity().body(bnfe.getMessage());
    }

}
