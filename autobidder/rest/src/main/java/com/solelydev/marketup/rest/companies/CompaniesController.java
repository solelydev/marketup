package com.solelydev.marketup.rest.companies;

import com.solelydev.marketup.companies.Company;
import com.solelydev.marketup.companies.CompanyAuth;
import com.solelydev.marketup.usecase.companies.AddCompany;
import com.solelydev.marketup.usecase.companies.ChangeCompanyAuth;
import com.solelydev.marketup.usecase.companies.ChangeCompanyName;
import com.solelydev.marketup.usecase.companies.DeleteCompany;
import com.solelydev.marketup.usecase.companies.GetAllCompanies;
import com.solelydev.marketup.usecase.companies.GetCompanyById;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/companies")
@Tag(name = "Компании", description = "API компаний")
public class CompaniesController {

  private final AddCompany addCompany;
  private final DeleteCompany deleteCompany;
  private final GetAllCompanies getAllCompanies;
  private final GetCompanyById getCompanyById;
  private final ChangeCompanyName changeCompanyName;
  private final ChangeCompanyAuth changeCompanyAuth;

  @Operation(summary = "Получить компанию")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Компания",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Company.class)))
      })
  @GetMapping("/{id}")
  public ResponseEntity<Company> getCompany(
      @Parameter(description = "ID компании", example = "c031d898-030b-40f8-85f6-d602021750bb")
          @PathVariable
          String id) {
    return ResponseEntity.ok(getCompanyById.execute(UUID.fromString(id)));
  }

  @Operation(summary = "Получить все компании")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Список компаний",
            content =
                @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = Company.class))))
      })
  @GetMapping
  public ResponseEntity<List<Company>> getAllCompanies() {
    return ResponseEntity.ok(getAllCompanies.execute());
  }

  @Operation(summary = "Добавить новую компанию")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "201",
            description = "Добавленная компания",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Company.class)))
      })
  @PostMapping
  public ResponseEntity<Company> addCompany(
      @Parameter(schema = @Schema(implementation = AddCompany.AddCompanyRequest.class)) @RequestBody
          AddCompany.AddCompanyRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(addCompany.execute(request));
  }

  @Operation(summary = "Удалить компанию по ее идентификатору")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "204", content = @Content(mediaType = "application/json"))
      })
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCompany(
      @Parameter(description = "ID компании", example = "c031d898-030b-40f8-85f6-d602021750bb")
          @PathVariable
          String id) {
    deleteCompany.execute(UUID.fromString(id));
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Изменить имя компании")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "202",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Company.class)))
      })
  @PutMapping("/{id}/changeName")
  public ResponseEntity<Company> changeCompanyName(
      @Parameter(description = "ID компании", example = "c031d898-030b-40f8-85f6-d602021750bb")
          @PathVariable
          String id,
      @Parameter(description = "Новое имя компании") @RequestParam String name) {
    return ResponseEntity.accepted().body(changeCompanyName.execute(id, name));
  }

  @Operation(summary = "Изменить параметры авторизации компании")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "202",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Company.class)))
      })
  @PutMapping("/{id}/changeAuth")
  public ResponseEntity<Company> changeCompanyAuth(
      @Parameter(description = "ID компании", example = "c031d898-030b-40f8-85f6-d602021750bb")
          @PathVariable
          String id,
      @Parameter(schema = @Schema(implementation = CompanyAuth.class)) @RequestBody
          CompanyAuth companyAuth) {
    return ResponseEntity.accepted().body(changeCompanyAuth.execute(id, companyAuth));
  }
}
