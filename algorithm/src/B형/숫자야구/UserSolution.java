package B형.숫자야구;

public class UserSolution {
    public final static int N = 4;
    static boolean possible[]; // 정답 가능성이 있는 경우
    static int number[];
    static int index;
    void init() {
        index = 0;
        number = new int[5040]; // 0123 ~ 9876까지 중복된 숫자가 없는 경우(5040)로 초기화
        possible = new boolean[9877];
        for(int i=123;i<=9876;i++) {
            int num1 = i / 1000;
            int num2 = i % 1000 / 100;
            int num3 = i % 100 / 10;
            int num4 = i % 10;
            if(num1 != num2 && num1 != num3 && num1 != num4 && num2 != num3 && num2 != num4 && num3 != num4) {
                number[index++] = i;
                possible[i] = true;
            }
        }
    }
    public void doUserImplementation(int guess[]) {
        init();
        int answer=0,ball=0,strike=0, target = 0, res = 0,ballCount[];
        while(true) {
            for(int i=0;i<index;i++) {
                if(possible[number[i]]) {
                    answer = number[i];
                    guess[0] = answer / 1000;
                    guess[1] = answer % 1000 / 100;
                    guess[2] = answer % 100 / 10;
                    guess[3] = answer % 10;
                    break;
                }
            }
            Solution.Result result = Solution.query(guess);

            if(result.strike == 4)break;
            else possible[answer] = false;

            for(int i=0;i<index;i++) {
                if(possible[number[i]]) {
                    res = answer;
                    target = number[i];
                    ball = 0;
                    strike = 0;
                    ballCount = new int[10];
                    for(int j=0;j<4;j++) {
                        if(res%10 == target%10)strike++;
                        else {
                            ballCount[res%10]++;
                            ballCount[target%10]++;
                        }
                        res/=10;
                        target/=10;
                    }
                    for(int j=0;j<10;j++) {
                        // res와 target 모두에 있으면 그 수는 ball이 됨
                        if(ballCount[j]==2)ball++;
                    }
                    // 가지치기
                    if(strike != result.strike || ball != result.ball) possible[number[i]] = false;
                }
            }
        }
    }
}