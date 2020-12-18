import bean.Sc;
import impl.ScImpl;
import org.junit.Test;

/**
 * @ClassName TestSc
 * @Description 测试Sc
 * @Author Huangbiao
 * @Date 2020-12-12 19:34
 * @Version V1.0
 */
public class TestSc {
    @Test
    public void test(){
        Sc sc = new Sc();
        sc.setSno("1807004345");
        sc.setCno("001");
        sc.setGrade("80");
        ScImpl scImpl = new ScImpl();
        scImpl.insert(sc);
    }
}
