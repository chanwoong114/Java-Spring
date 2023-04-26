package B형.오타교정시스템;

class UserSolution {

	static class db {
		int idx;
		char[] typo;
		char[] hit;

		db(int idx, char[] typo, char[] hit) {
			this.idx = idx;
			this.typo = typo;
			this.hit = hit;
		}
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

	// 사전 만들기
    void init(int n) {
    }

	// 검색 전에 나왔던 것들 중에서 있는지 없는지
    int search(int mId, int searchTimestamp, char[] searchWord, char[][] correctWord) {
		// 전에 나온게 없다면 적재
		// 있다면 기록 남기기 galacy -> galaxy

		// 검색한 기록이 3명이라면 교정해주기

		// 그에 맞는 기록 개수
        return 0;
    }
}
