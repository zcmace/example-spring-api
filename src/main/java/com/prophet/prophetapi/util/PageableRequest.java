package com.prophet.prophetapi.util;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageableRequest {

  @Min(value = 5, message = "Minimum number of rows per page is 5")
  private int pageSize;
  @Min(value = 0, message = "Page number must be greater than or equal to 0")
  private int pageNumber;
  @Schema(description = "Sort direction", example = "ASC", allowableValues = {"ASC", "DESC"})
  private String sortDirection;
  @Schema(description = "Sort by", example = "fieldName")
  private String sortBy;
}
