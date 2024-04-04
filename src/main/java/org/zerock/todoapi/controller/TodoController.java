package org.zerock.todoapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.zerock.todoapi.dto.PageRequestDTO;
import org.zerock.todoapi.dto.PageResponseDTO;
import org.zerock.todoapi.dto.TodoDTO;
import org.zerock.todoapi.service.TodoService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/todo")
@Tag(name = "TODO API", description = "TodoController")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/{tno}")
    @Operation(summary = "TODO 조회", description = "TODO 하나를 조회합니다.")
    public TodoDTO get(@PathVariable("tno") Long tno) {
        return todoService.get(tno);
    }


    @GetMapping("/list")
    @Operation(summary = "TODO 리스트 조회", description = "페이지 번호와 사이즈에 맞는 TODO 리스트를 조회합니다.")
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호, 1부터 시작", example = "1"),
            @Parameter(name = "size", description = "페이지 사이즈", example = "10"),
    })
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {
        return todoService.getList(pageRequestDTO);
    }

    @PostMapping("/")
    @Operation(summary = "TODO 생성", description = "TODO 하나를 생성합니다.")
    @Parameters({
            @Parameter(name = "title", description = "TODO 제목", example = "Title.."),
            @Parameter(name = "content", description = "TODO 내용, 500자 이내", example = "Content.."),
            @Parameter(name = "dueDate", description = "TODO 마감 날짜", example = "2024-03-12"),
    })
    @ApiResponse(
            responseCode = "200",
            description = """
                    {
                      "TNO": {tno}
                    }
                    """
    )
    public Map<String, Long> register(@RequestBody TodoDTO dto) {
        long tno = todoService.register(dto);
        return Map.of("TNO", tno);
    }

    @PutMapping("/{tno}")
    @Operation(summary = "TODO 수정", description = "TODO 하나를 수정합니다.")
    @Parameters({
            @Parameter(name = "tno", description = "수정할 TODO 번호", example = "1"),
            @Parameter(name = "title", description = "수정할 TODO 제목", example = "Modified Title.."),
            @Parameter(name = "content", description = "수정할 TODO 내용, 500자 이내", example = "Modified Content.."),
            @Parameter(name = "complete", description = "수정할 TODO의 마감 여부", example = "true"),
            @Parameter(name = "dueDate", description = "수정할 TODO 마감 날짜", example = "2024-03-12"),
    })
    @ApiResponse(
            responseCode = "200",
            description = """
                    {
                      "RESULT": "SUCCESS"
                    }
                    """
    )
    public Map<String, String> modify(@PathVariable("tno") Long tno,
                                      @RequestBody TodoDTO dto) {
        dto.setTno(tno);
        todoService.modify(dto);
        return Map.of("RESULT", "SUCCESS");
    }

    @DeleteMapping("/{tno}")
    @ApiResponse(
            responseCode = "200",
            description = """
                    {
                      "RESULT": "SUCCESS"
                    }
                    """
    )
    @Operation(summary = "TODO 삭제", description = "TODO 하나를 삭제합니다.")
    public Map<String, String> remove(@PathVariable("tno") Long tno) {
        todoService.remove(tno);
        return Map.of("RESULT", "SUCCESS");
    }

}
