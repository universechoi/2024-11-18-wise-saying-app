package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private final Scanner scanner;
    private int lastId;
    private final List<WiseSaying> wiseSayingList;

    public App() {
        scanner = new Scanner(System.in);
        lastId = 0;
        wiseSayingList = new ArrayList<>();
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
                actionList();
            } else if (cmd.startsWith("삭제")) {
                String idStr = cmd.substring(6);
                int id = Integer.parseInt(idStr);

                actionDelete(id);
            } else if (cmd.startsWith("수정")) {
                String idStr = cmd.substring(6);
                int id = Integer.parseInt(idStr);

                actionModify(id);
                System.out.println(id + "번 명언은 존재하지 않습니다.");
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

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (WiseSaying wiseSaying : wiseSayingList.reversed()) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }

    private void actionDelete(int id) {
        boolean removed = wiseSayingList.removeIf(wiseSaying -> wiseSaying.getId() == id);

        if (removed) {
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }

    private void actionModify(int id) {
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
