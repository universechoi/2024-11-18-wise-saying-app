package com.ll.domain.wiseSaying;

import com.ll.WiseSaying;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    public void actionList(List<WiseSaying> wiseSayingList) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (WiseSaying wiseSaying : wiseSayingList.reversed()) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }

    public void actionDelete(List<WiseSaying> wiseSayingList, String cmd) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);

        boolean removed = wiseSayingList.removeIf(wiseSaying -> wiseSaying.getId() == id);

        if (removed) {
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }


    public void actionModify(Scanner scanner, List<WiseSaying> wiseSayingList, String cmd) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);

        WiseSaying foundWiseSaying = null;

        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == id) {
                foundWiseSaying = wiseSaying;
                break;
            }
        }

        if (foundWiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println("명언(기존) : " + foundWiseSaying.getContent());
        System.out.print("명언 : ");

        String newWiseSaying = scanner.nextLine();
        foundWiseSaying.setContent(newWiseSaying);

        System.out.println("작가(기존) : " + foundWiseSaying.getAuthor());
        System.out.print("작가 : ");

        String newAuthor = scanner.nextLine();
        foundWiseSaying.setAuthor(newAuthor);

        System.out.println(id + "번 명언이 수정되었습니다.");
    }
}
