package custom;

public class StringExMain {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("1234567890");
		StringBuilder builder = new StringBuilder("1234567890");
		builder.reverse();
		sb.reverse();
		System.out.println(sb.toString());
		System.out.println(builder.toString());
	}
}
