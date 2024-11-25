package com.ll;

import com.ll.domain.wiseSaying.WiseSayingController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private final Scanner scanner;
    private int lastId;
    private final List<WiseSaying> wiseSayingList;
    private final WiseSayingController wiseSayingController;

    public App() {
        scanner = new Scanner(System.in);
        lastId = 0;
        wiseSayingList = new ArrayList<>();
        wiseSayingController = new WiseSayingController();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        makeSampleData();

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionAdd();
            } else if (cmd.equals("목록")) {
                wiseSayingController.actionList(wiseSayingList);
            } else if (cmd.startsWith("삭제")) {
                wiseSayingController.actionDelete(wiseSayingList, cmd);
            } else if (cmd.startsWith("수정")) {
                wiseSayingController.actionModify(scanner, wiseSayingList, cmd);
            }
        }
        scanner.close();
    }

    private void makeSampleData() {
        addWiseSaying("나의 죽음을 적들에게 알리지 말라.", "이순신 장군");
        addWiseSaying("삶이 있는 한 희망은 있다.", "키케로");
    }

    private void addWiseSaying(String content, String author) {
        ++lastId;

        wiseSayingList.add(new WiseSaying(lastId, content, author));
        System.out.println(lastId + "번 명언이 등록되었습니다.");
    }

    private void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        addWiseSaying(content, author);
    }
}
