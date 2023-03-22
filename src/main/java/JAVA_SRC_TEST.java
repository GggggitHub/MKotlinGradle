import java.util.Random;

/**
 * @author Ajie
 * @date 2022/5/30
 * @function 测试 JAVA 环境。
 * 如果出问题。
 * 1.换个 idea 版本打开。此project。
 * 2.然后在用 这个 版本 idea 打开 this project.
 */
public class JAVA_SRC_TEST {
    public static void main(String[] args) {
        int i = new Random(10).nextInt();
        System.err.println("IDEA_TEST_JAVA:main: well down. random:"+i);
    }
    public void main(){
        System.out.println("JAVA_SRC_TEST:main:---");
    }
}
