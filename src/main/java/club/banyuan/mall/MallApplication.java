package club.banyuan.mall;

//import org.mybatis.generator.api.MyBatisGenerator;
//import org.mybatis.generator.config.Configuration;
//import org.mybatis.generator.config.xml.ConfigurationParser;
//import org.mybatis.generator.internal.DefaultShellCallback;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 用于生产MBG的代码
// */
//@MapperScan({"club.banyuan.mall.common.mapper"})
//@SpringBootApplication
//@RestController
//
//public class MallApplication {
//
//    public static void main(String[] args) throws Exception {
//        //MBG 执行过程中的警告信息
//        List<String> warnings = new ArrayList<String>();
//
//        //当生成的代码重复时，覆盖原代码
//        boolean overwrite = true;
//
//        //读取我们的 MBG 配置文件
//        InputStream is = MallApplication.class.getResourceAsStream("/generatorConfig.xml");
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(is);
//        is.close();
//
//        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//
//        //创建 MBG
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//
//        //执行生成代码
//        myBatisGenerator.generate(null);
//
//        //输出警告信息
//        for (String warning : warnings) {
//            System.out.println(warning);
//        }
//    }
//}
import club.banyuan.mall.common.mapper.UmsRoleMapper;
import club.banyuan.mall.common.model.UmsRole;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@MapperScan({"club.banyuan.mall.common.mapper"})
@SpringBootApplication
@RestController
public class MallApplication {

    @Autowired
    private UmsRoleMapper roleMapper;

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

    @GetMapping(value = "/")
    public String index() {

        //        UmsRole role = new UmsRole();
        //        role.setName("管理员");
        //        role.setDescription("管理员不用介绍");
        //        role.setStatus(true);
        //        role.setCreateTime(new Date());
        //        roleMapper.insert(role);

        UmsRole role = roleMapper.selectByPrimaryKey(1L);

        return "<p>" + role.toString() + "</p>";
    }
    @GetMapping(value ="/hello" )
    public String hello(){
        return "HELLO";
    }
    @GetMapping(value = "/hello2")
    public  String hello2(){
        return "HELLO";
    }



}