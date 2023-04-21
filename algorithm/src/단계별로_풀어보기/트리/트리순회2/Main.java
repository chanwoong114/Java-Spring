package 단계별로_풀어보기.트리.트리순회2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, idx;
    static int[] inorder, postorder, preorder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        idx = 0;

        inorder = new int[N];
        postorder = new int[N];
        preorder = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        getPreOrder(0, N - 1, 0, N - 1);

        for (int n: preorder) {
            System.out.print(n + " ");
        }
    }

    static void getPreOrder(int is, int ie, int ps, int pe) {

        if (is <= ie && ps <= pe) {
            preorder[idx++] = postorder[pe];

            int pos = is;
            for (int i = is; i <= ie; i++) {
                if (inorder[i] == postorder[pe]) {
                    pos = i;
                    break;
                }
            }

            getPreOrder(is, pos - 1, ps, ps + pos - is - 1);
            getPreOrder(pos + 1, ie, ps + pos - is, pe - 1);
        }
    }
}
