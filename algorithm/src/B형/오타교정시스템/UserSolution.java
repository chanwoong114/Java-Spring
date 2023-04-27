package B형.오타교정시스템;

import java.util.*;

class UserSolution {

    static HashMap<Integer, HashMap<Integer, String>> userSearchList; // 유저 검색 기록 <id: <시간:단어>>

    // 이중 해시맵 정타에 오타들 모음 오타에 대한 유저 id set <정타: <오타: 유저set>>
    static HashMap<String, HashMap<String, HashSet<Integer>>> inCorrectDB;
    static int correctionCnt; // correctionWord의 마지막 인덱스
    static char[][] correctionWord; // 교정된 정타를 저장해 두는 배열
    static HashMap<String, ArrayList<String>> corPair; // 오타 정타 리스트
    static HashMap<String, Integer> words; // correctionWord에 저장된 정타의 인덱스 < 정타 : 인덱스>


    // 사전 만들기
    void init(int n) {
        userSearchList = new HashMap<>();
        inCorrectDB = new HashMap<>();
        correctionCnt = 0;
        corPair = new HashMap<>();
        words = new HashMap<>();
        correctionWord = new char[10000][11];
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 5; j++) {
                correctionWord[i][j] = ' ';
            }
        }
    }

    // 검색 전에 나왔던 것들 중에서 있는지 없는지
    int search(int mId, int searchTimestamp, char[] searchWord, char[][] correctWord) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        // 입력된 단어 추출
        for (int i = 0; i <= 10; i++) {
            if ('a' <= searchWord[i] && searchWord[i] <= 'z') sb.append(searchWord[i]);
        }

        String sWord = sb.toString();

        // 오타가 등록되어 있는 경우
        int index = 0;
        // 오타 배열에 검색한 단어가 있는 지 확인
        if (corPair.keySet().contains(sWord)) {
            // 유저 서치 리스트 - 이 문자를 오타로 안쳐봤다면 새로운 공간 생성
            if (!userSearchList.containsKey(mId)) userSearchList.put(mId, new HashMap<>());

            // 오타에 맞는 정타 개수만큼 포문
            for (int i = 0; i < corPair.get(sWord).size(); i++) {
                // 정타 입력받아서
                String s = corPair.get(sWord).get(i);
                // correctionWord 리스트에 맞는 인덱스 찾아와서 correctWord에 넣어주기
                int idx = words.get(s);
                for (int j = 0; j < 11; j++) {
                    correctWord[index][j] = correctionWord[idx][j];
                }
                index++;
            }
        }

        if (userSearchList.containsKey(mId)) {
            // 유저 검색 기록 있는지 없는지
            for (int time: userSearchList.get(mId).keySet()) {
                // 최근 검색 기록이 10초 이내인지
                if (searchTimestamp - time <= 10 && searchTimestamp - time > 0) {
                    String w = userSearchList.get(mId).get(time);
                    // 전에 검색과 같다면 리턴
                    if (w.equals(sWord)) return index;

                    int ret = check(sWord, w); // 오타체크
                    if (ret == 0 || ret == 1 || ret == -1) {
                        // 이미 입력된 오타인지
                        if (inCorrectDB.containsKey(sWord)) {
                            HashMap inCorMap = inCorrectDB.get(sWord);
                            if (inCorMap.containsKey(w)) {
                                HashSet set = (HashSet) inCorMap.get(w);

                                //해당 오타 입력한 유저가 유저 set에 있는지
                                if (!set.contains(mId)) {
                                    set.add(mId);

                                    // 3명이면 오타 db에 등록
                                    if (set.size() == 3) {
                                        // 이미 오타가 등록되어 있으면
                                        if (corPair.containsKey(w)) {
                                            // 오타에 대한 정타들 리스트 뒤에 추가
                                            corPair.get(w).add(sWord);
                                        }
                                        else {
                                            // 새로운 오타일 경우
                                            corPair.put(w, new ArrayList<>());
                                            corPair.get(w).add(sWord);
                                        }
                                        // correctionWord에서 정타의 인덱스를 기록
                                        if (!words.keySet().contains(sWord)) {
                                            for (int i = 0; i < sWord.length(); i++) {
                                                correctionWord[correctionCnt][i] = sWord.charAt(i);
                                            }
                                            words.put(sWord, correctionCnt);
                                            correctionCnt++;

                                        }
                                        return index;
                                    }
                                }
                            }
                            //
                            else {
                                inCorMap.put(w, new HashSet<>());
                                HashSet set = (HashSet) inCorMap.get(w);
                                set.add(mId);
                            }
                        }
                        // 오타 교정 db에 없다면
                        else {
                            inCorrectDB.put(sWord, new HashMap<>());
                            inCorrectDB.get(sWord).put(w, new HashSet<>());
                            inCorrectDB.get(sWord).get(w).add(mId);
                        }
                    }
                    break;
                }
                else queue.add(time);
            }
        }
        else {
            userSearchList.put(mId, new HashMap<>());
        }

        userSearchList.get(mId).put(searchTimestamp, sWord);

        while (!queue.isEmpty()) {
            int a = queue.poll();
            userSearchList.get(mId).remove(a);
        }

        return index;
    }

    int check (String s1, String s2) {
        int[] dat1 = new int[27];
        int[] dat2 = new int[27];

        for (int i = 0; i < s1.length(); i++) {
            dat1[s1.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            dat2[s2.charAt(i) - 'a'] += 1;
        }

        int ret = 0;
        for (int i = 0; i < 26; i++) {
            ret += dat2[i] - dat1[i];
        }

        return ret;
    }

    // The below commented methods are for your reference. If you want
    // to use it, uncomment these methods.
    //
    int mstrcmp(char[] a, char[] b) {
        int i;
        for (i = 0; a[i] != '\0'; i++) {
            if (a[i] != b[i])
                return a[i] - b[i];
        }
        return a[i] - b[i];
    }

    int mstrncmp(char[] a, char[] b, int len) {
        for (int i = 0; i < len; i++) {
            if (a[i] != b[i])
                return a[i] - b[i];
        }
        return 0;
    }

    int mstrlen(char[] a) {
        int len = 0;

        while (a[len] != '\0')
            len++;

        return len;
    }

    void mstrcpy(char[] dest, char[] src) {
        int i = 0;
        while (src[i] != '\0') {
            dest[i] = src[i];
            i++;
        }
        dest[i] = src[i];
    }

    void mstrncpy(char[] dest, char[] src, int len) {
        for (int i = 0; i < len; i++) {
            dest[i] = src[i];
        }
        dest[len] = '\0';
    }
}
