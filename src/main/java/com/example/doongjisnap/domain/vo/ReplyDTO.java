package com.example.doongjisnap.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
    private List<ReplyVO> replies;
    private int replyCount;
}
