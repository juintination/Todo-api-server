package org.zerock.todoapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "TODO DTO")
public class TodoDTO {

    @Schema(description = "TODO 식별 번호", defaultValue = "0")
    private Long tno;

    @Schema(description = "TODO 제목", example = "Title..")
    private String title;

    @Schema(description = "TODO 내용", example = "Content..")
    private String content;

    @Schema(description = "TODO 완료 여부", defaultValue = "false")
    private boolean complete;

    @Schema(description = "TODO 마감 일자", example = "2024-03-12")
    private LocalDate dueDate;

}
