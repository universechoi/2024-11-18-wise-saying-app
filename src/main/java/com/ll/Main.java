package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}

class App {

    private Scanner scanner;
    private int lastId;
    private ArrayList<WiseSaying> wiseSayingList;

    public App() {
        scanner = new Scanner(System.in);
        lastId = 0;
        wiseSayingList = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
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
                        System.out.println("명언(기존) : " + wiseSaying.content);
                        System.out.print("명언 : ");

                        String newWiseSaying = scanner.nextLine();
                        wiseSaying.content = newWiseSaying;

                        System.out.println("작가(기존) : " + wiseSaying.author);
                        System.out.print("작가 : ");

                        String newAuthor = scanner.nextLine();
                        wiseSaying.author = newAuthor;
                    }
                }
            }
        }
        scanner.close();
    }

    class WiseSaying {
        public int id;
        public String content;
        public String author;

        public WiseSaying(int id, String content, String author) {
            this.id = id;
            this.content = content;
            this.author = author;
        }
    }

    private void addWiseSaying(String content, String author) {
        wiseSayingList.add(new WiseSaying(lastId, content, author));
        System.out.println(lastId + "번 명언이 등록되었습니다.");
    }

    private void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();

        System.out.print("작가 : ");
        String author = scanner.nextLine();

        ++lastId;

        addWiseSaying(content, author);
    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying != null) {
                System.out.println(wiseSaying.id + " / " + wiseSaying.author + " / " + wiseSaying.content);
            }
        }
    }
}