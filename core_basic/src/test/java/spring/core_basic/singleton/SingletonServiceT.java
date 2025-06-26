package spring.core_basic.singleton;

/**
 * @author rua
 */
public class SingletonServiceT {
    private static final SingletonServiceT instance = new SingletonServiceT();
    public static SingletonServiceT getInstance() {
        return instance;
    }

    private SingletonServiceT() {}

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
