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
    public void run() {
        System.out.println("== 명언 앱 ==");

        Scanner scanner = new Scanner(System.in);

        int lastId = 0;

        ArrayList<WiseSaying> wiseSayingList = new ArrayList<>();

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content = scanner.nextLine();

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                int id = ++lastId;

                wiseSayingList.add(new WiseSaying(id, content, author));
                System.out.println(id + "번 명언이 등록되었습니다.");

            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
                    WiseSaying wiseSaying = wiseSayingList.get(i);
                    if (wiseSaying != null) {
                        System.out.println(wiseSaying.id + " / " + wiseSaying.author + " / " + wiseSaying.content);
                    }
                }
            } else if (cmd.startsWith("삭제?id=")) {
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
                    }
                }
            }
        }
        scanner.close();
    }

    class WiseSaying {
        int id;
        String content;
        String author;

        WiseSaying(int id, String content, String author) {
            this.id = id;
            this.content = content;
            this.author = author;
        }
    }
}