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
            } else if (cmd.startsWith("삭제?id=") || cmd.startsWith("수정?id=")) {
                String number = cmd.split("=")[1];
                int id = Integer.parseInt(number);

                if (id > wiseSayingList.size()) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                } else {
                    WiseSaying wiseSaying = wiseSayingList.get(id - 1);

                    if (wiseSaying == null) {
                        System.out.println(id + "번 명언은 존재하지 않습니다.");
                    } else if (cmd.contains("삭제")) {
                        wiseSayingList.set(id - 1, null);
                        System.out.println(id + "번 명언이 삭제되었습니다.");
                    } else {
                        System.out.println("명언(기존) : " + wiseSaying.getContent());
                        System.out.print("명언 : ");

                        String newWiseSaying = scanner.nextLine();
                        wiseSaying.setContent(newWiseSaying);

                        System.out.println("작가(기존) : " + wiseSaying.getAuthor());
                        System.out.print("작가 : ");

                        String newAuthor = scanner.nextLine();
                        wiseSaying.setAuthor(newAuthor);
                    }
                }
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
            if (wiseSaying != null) {
                System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
            }
        }
    }
}