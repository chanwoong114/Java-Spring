package B형.오타교정시스템;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class UserSol {

    static HashMap<Integer,HashMap<Integer,String>> userSearchList;         //유저 검색 기록 <id:<시간:단어>>
    // 이중 해쉬맵 정타에 대한 오타들 모음 그리고 오타에 대한 유저 id set <정타:<오타:유저set>>
    static HashMap<String,HashMap<String,HashSet<Integer>>> inCorrectDB;
    static int correctionCnt;   //correctionWord의 마지막 인덱스
    static char[][] correctionWord;  //교정된 정타를 저장해두는 배열
    static HashMap<String,ArrayList<String>> corPair;   //오타 : 정타 리스트
    static HashMap<String,Integer> words;   //correctionWord에 저장된 정타의 인덱스  <정타:인덱스>

    void init(int n) {
        userSearchList=new HashMap<>();
        inCorrectDB=new HashMap<>();
        correctionCnt=0;
        corPair=new HashMap<>();
        words=new HashMap<>();
        correctionWord=new char[10000][11];
        for(int i=0;i<10000;i++) {
            for(int j=0;j<5;j++) {
                correctionWord[i][j]=' ';
            }
        }
    }

    int search(int mId, int searchTimestamp, char[] searchWord, char[][] correctWord) {
        StringBuilder sb=new StringBuilder();
        Queue<Integer> q=new LinkedList<>();
        //입력된 단어 추출
        for(int i=0;i<=10;i++) {
            if('a'<=searchWord[i]&&searchWord[i]<='z')sb.append(searchWord[i]);
            else break;
        }
        String sWord=sb.toString();

        //오타가 등록되어 있는 경우
        int index=0;
        if(corPair.keySet().contains(sWord)) {
            if(!userSearchList.containsKey(mId))userSearchList.put(mId,new HashMap<>());
            //userSearchList.get(mId).put(searchTimestamp, sWord);

            for(int i=0;i<corPair.get(sWord).size();i++) {
                String s=corPair.get(sWord).get(i);
                int idx=words.get(s);
                for(int j=0;j<=10;j++)correctWord[index][j]=correctionWord[idx][j];
                index++;
            }
            //return index;
        }

        if(userSearchList.containsKey(mId)) {       //유저 검색 기록 있는지
            for(int time:userSearchList.get(mId).keySet()) {
                if(searchTimestamp-time<=10&&searchTimestamp-time>0) {  //10초 이내인지
                    String w=userSearchList.get(mId).get(time);
                    if(w.equals(sWord))return index;
                    int ret=check(sWord,w);         //오타 체크
                    if(ret==0||ret==1||ret==-1) {
                        if(inCorrectDB.containsKey(sWord)) {        //이미 입력되었던 오타인지
                            HashMap inCorMap=inCorrectDB.get(sWord);
                            if(inCorMap.containsKey(w)) {
                                HashSet set=(HashSet) inCorMap.get(w);
                                if(!set.contains(mId)) {    //해당 오타 입력 유저set에 있는지
                                    set.add(mId);
                                    if(set.size()==3) {         //3명이면 오타db에 등록
                                        if(corPair.containsKey(w)) {
                                            corPair.get(w).add(sWord); //이미 오타가 등록되어 있으면 오타에 대한 정타들 리스트 뒤에 추가
                                        }
                                        else {
                                            corPair.put(w,new ArrayList<>());   //새로운 오타일 경우
                                            corPair.get(w).add(sWord);
                                        }
                                        if(!words.keySet().contains(sWord)) {   //correctionWord에서 정타의 인덱스를 기록
                                            for(int i=0;i<sWord.length();i++)correctionWord[correctionCnt][i]=sWord.charAt(i);
                                            words.put(sWord, correctionCnt);
                                            correctionCnt++;
                                        }
                                        return index;
                                    }
                                }
                            }
                            else {
                                inCorMap.put(w, new HashSet<>());
                                HashSet set=(HashSet) inCorMap.get(w);
                                set.add(mId);
                            }
                        }
                        else {
                            inCorrectDB.put(sWord,new HashMap<>());
                            inCorrectDB.get(sWord).put(w,new HashSet<>());
                            inCorrectDB.get(sWord).get(w).add(mId);
                        }
                    }
                    break;
                }
                else q.add(time);
            }
        }
        else {
            userSearchList.put(mId,new HashMap<>());
        }

        userSearchList.get(mId).put(searchTimestamp, sWord);

        while(!q.isEmpty()) {       //필요 없는 유저 검색 기록 삭제
            int a=q.poll();
            userSearchList.get(mId).remove(a);
        }

        return index;       //정타의 개수 리턴
    }

    static int check(String s1,String s2) {
        //0번 인덱스 'a' dat에 문자의 개수 기록
        //둘의 차이가 1이면 문자가 하나 추가된 오타
        //0이면 문자 하나 치환된 오타
        //-1이면 문자 하나 삭제된 오타
        int[] dat1=new int[27];
        int[] dat2=new int[27];
        for(int i=0;i<s1.length();i++)dat1[s1.charAt(i)-'a']+=1;
        for(int i=0;i<s2.length();i++)dat2[s2.charAt(i)-'a']+=1;
        int ret=0;
        for(int i=0;i<=26;i++)ret+=dat2[i]-dat1[i];
        return ret;
    }
}