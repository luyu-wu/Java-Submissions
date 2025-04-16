public class test {

    public static void main(String[] args) {
        String test = "hellooo";

        for (char i : test.toCharArray()) {
            System.out.println(i);
        }
        String test2 = "hello world";
        char test3 = '!';
        test2 += test3;
        System.out.println(test2);
        if (test2.equals("hello world!")) {
            System.out.println("test2 is equal to 'hello world!'");
        } else if (test2.equals("hello world")) {
            System.out.println("test2 is equal to 'hello world'");
        } else {
            System.out.println(
                "test2 is not equal to 'hello world!' or 'hello world'"
            );
        }
    }
}
