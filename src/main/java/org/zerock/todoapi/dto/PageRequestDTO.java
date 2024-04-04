package org.zerock.todoapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "페이지 요청 DTO")
public class PageRequestDTO {

    @Builder.Default
    @Schema(description = "요청 페이지 번호", defaultValue = "1")
    private int page = 1;

    @Builder.Default
    @Schema(description = "한 페이지에 들어가는 TODO의 개수", defaultValue = "10")
    private int size = 10;

}
