package com.ll.domain.wiseSaying.service;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingService {
    private static List<WiseSaying> wiseSayingList;
    private static int lastId;

    public WiseSayingService() {
        lastId = 0;
        wiseSayingList = new ArrayList<>();
    }

    public static void addWiseSaying(String content, String author) {
        ++lastId;

        wiseSayingList.add(new WiseSaying(lastId, content, author));
        System.out.println(lastId + "번 명언이 등록되었습니다.");
    }

    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }

    public boolean removeById(int id) {
        return wiseSayingList.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayingList.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst();
    }
}
