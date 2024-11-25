package com.ll.domain.wiseSaying;

import com.ll.WiseSaying;
import java.util.List;

public class WiseSayingController {

    public void actionList(List<WiseSaying> wiseSayingList) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (WiseSaying wiseSaying : wiseSayingList.reversed()) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }
}
