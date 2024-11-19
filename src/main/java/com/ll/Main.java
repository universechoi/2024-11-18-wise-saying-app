package com.ll;

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

        int count = 1;

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            }
            if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = scanner.nextLine();

                System.out.print("작가 : ");
                String author = scanner.nextLine();

                System.out.println(count + "번 명언이 등록되었습니다.");
                count++;
            }
        }
        scanner.close();
    }
}