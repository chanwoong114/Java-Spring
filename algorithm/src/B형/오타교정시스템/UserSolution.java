package B형.오타교정시스템;

import java.util.*;

class UserSolution {

    static HashMap<Integer, HashMap<Integer, String>> userSearchList;
    static HashMap<String, HashMap<String, HashSet<Integer>>> inCorrectDB;
    static int correctionCnt;
    static char[][] correctionWord;
    static HashMap<String, ArrayList<String>> corPair;
    static HashMap<String, Integer> words;


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
        for (int i = 0; i < 10; i++) {
            if ('a' <= searchWord[i] && searchWord[i] <= 'z') sb.append(searchWord[i]);
            else break;
        }
        String sWord = sb.toString();

        int index = 0;
        if (corPair.keySet().contains(sWord)) {
            if (!userSearchList.containsKey(mId)) userSearchList.put(mId, new HashMap<>());
        }

        return 0;
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
