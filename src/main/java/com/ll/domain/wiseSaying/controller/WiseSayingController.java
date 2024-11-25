package com.ll.domain.wiseSaying.controller;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WiseSayingController {
    private final WiseSayingService wiseSayingService;


    public WiseSayingController() {
        this.wiseSayingService = new WiseSayingService();
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayingList = wiseSayingService.findAll();

        for (WiseSaying wiseSaying : wiseSayingList.reversed()) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }

    public void actionDelete(String cmd) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);

        boolean removed = wiseSayingService.removeById(id);

        if (removed) {
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }


    public void actionModify(Scanner scanner, String cmd) {
        String idStr = cmd.substring(6);
        int id = Integer.parseInt(idStr);

        Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(id);

        if (opWiseSaying.isEmpty()) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        WiseSaying foundWiseSaying = opWiseSaying.get();

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

    public void actionAdd(Scanner scanner) {
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSayingService.addWiseSaying(content, author);
    }

    public void makeSampleData() {
        WiseSayingService.addWiseSaying("나의 죽음을 적들에게 알리지 말라.", "이순신 장군");
        WiseSayingService.addWiseSaying("삶이 있는 한 희망은 있다.", "키케로");
    }
}
