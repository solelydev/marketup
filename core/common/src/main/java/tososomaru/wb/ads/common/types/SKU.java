package tososomaru.wb.ads.common.types;

import io.vavr.control.Either;
import io.vavr.control.Try;
import tososomaru.wb.ads.common.base.ValueObject;

import java.net.URI;

import static io.vavr.control.Either.left;
import static io.vavr.control.Either.right;

/**
 * Внутренний уникальный идентификатор карточки товара на WB
 */
public class SKU implements ValueObject {

    private final Integer value;

    private SKU(Integer value) {
        this.value = value;
    }

    public static Either<CreateSKUError, SKU> from(String itemNumber) {
        return Try.of(() -> Integer.parseInt(itemNumber))
                .map(SKU::from)
                .fold(ex -> left(new InvalidNumberFormatError()), Either::right);
    }

    public static SKU from(Integer itemNumber) {
        return new SKU(itemNumber);
    }

    public static Either<CreateSKUError, SKU> from(URI url) {
        var path = url.getPath();
        var splitPath = path.split("/");
        if (splitPath.length < 1) {
            return left(new InvalidUrlError());
        }
        return right(new SKU(Integer.parseInt(splitPath[1])));
    }

    public static Either<CreateSKUError, SKU> create(String urlOrItemNumber) {
        return Try.of(() -> URI.create(urlOrItemNumber))
                .fold(ex -> SKU.from(urlOrItemNumber), SKU::from);
    }

    public Integer getValue() {
        return value;
    }

    public sealed interface CreateSKUError permits InvalidUrlError, InvalidNumberFormatError {}
    static final class InvalidUrlError implements CreateSKUError {}
    static final class InvalidNumberFormatError implements CreateSKUError {}
}
