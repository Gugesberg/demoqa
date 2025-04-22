import org.junit.jupiter.api.*;



public class SimpleJunitTest {
    int result;

    @BeforeAll
    static  void beforeAll() {
        System.out.println("Перед всеми скриптами");
    }

    @BeforeEach
    void beforeTest(){
        System.out.println("Пререквест");
         result = getResult();
    }

    @Test
    void succesfulSearchTest() {
        System.out.println("Первый");
        Assertions.assertTrue(result>2);

    }
    @Test
    void firstTest() {
        System.out.println("Второй");
        Assertions.assertTrue(result>2);
    }
    @Test
    void secondTest() {
        System.out.println("Третий");
        Assertions.assertTrue(result>2);
    }
    private int getResult(){
        return 3;
    }
    @AfterEach
    void clearResult(){
        System.out.println("Постреспонс");
        result = 0;
    }
    @AfterAll
    static void afterAll() {
        System.out.println("После всех скриптов");
    }
}

