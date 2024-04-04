package org.zerock.todoapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@Schema(description = "페이지 응답 DTO")
public class PageResponseDTO<E> {

    @Schema(description = "현재 페이지의 TODO DTO 리스트")
    private List<E> dtoList;

    @Schema(description = "현재 페이지에서 볼 수 있는 페이지 번호 리스트")
    private List<Integer> pageNumList;

    @Schema(description = "페이지 요청 DTO")
    private PageRequestDTO pageRequestDTO;

    @Schema(description = "이전 페이지 리스트 존재 여부")
    private boolean prev;

    @Schema(description = "다음 페이지 리스트 존재 여부")
    private boolean next;

    @Schema(description = "전체 TODO 개수")
    private int totalCount;

    @Schema(description = "이전 페이지 리스트의 시작 번호")
    private int prevPage;

    @Schema(description = "다음 페이지 리스트의 시작 번호")
    private int nextPage;

    @Schema(description = "현재 페이지에서 볼 수 있는 페이지 개수")
    private int totalPage;

    @Schema(description = "현재 페이지 번호")
    private int current;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(List<E> dtoList, PageRequestDTO pageRequestDTO, long totalCount) {

        this.dtoList = dtoList;
        this.pageRequestDTO = pageRequestDTO;
        this.totalCount = (int) totalCount;

        int end = (int) (Math.ceil(pageRequestDTO.getPage() / 10.0)) *  10;
        int start = end - 9;
        int last = (int) (Math.ceil((totalCount / (double) pageRequestDTO.getSize())));

        end = Math.min(end, last);

        this.prev = start > 1;
        this.next = totalCount > (long) end * pageRequestDTO.getSize();
        this.pageNumList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());

        if (prev) {
            this.prevPage = start -1;
        }

        if (next) {
            this.nextPage = end + 1;
        }

        this.totalPage = this.pageNumList.size();
        this.current = pageRequestDTO.getPage();

    }
}
