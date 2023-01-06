package gdsc.yolog.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class WritePostReq {

    @ApiModelProperty (example = "게시글 제목") // Swagger문서에 명시하기 위한 Annotation
    private String title;

    @ApiModelProperty (example = "게시글") // Swagger문서에 명시하기 위한 Annotation
    private String content;

    @Builder
    public WritePostReq(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
