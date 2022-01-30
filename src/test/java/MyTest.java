import com.mapper.BrandMapper;
import com.pojo.Brand;
import com.pojo.PageBean;
import com.service.BrandService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Create by LCX on 1/26/2022 9:56 PM
 */
public class MyTest {
    @Test
    public void test1(){
        ApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        BrandService brandServiceImpl = context.getBean("brandServiceImpl", BrandService.class);
        Brand brand = brandServiceImpl.selectBrandById(1);
        System.out.println(brand);
    }

    @Test
    public void test2(){
        ApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        BrandService brandService = context.getBean("brandServiceImpl", BrandService.class);
        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(1, 5, new Brand());
        System.out.println(brandPageBean);
    }
}
