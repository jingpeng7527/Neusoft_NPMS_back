package com.neusoft.npms;


import com.macro.cloud.Oauth2AuthApplication;
import com.macro.cloud.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = Oauth2AuthApplication.class)
public class test {

//    @Autowired
//    IChanceTypeProductService chanceTypeProductService;
//    @Test
//    public void test(){
//        ChanceQueryCondition chanceQueryCondition = new ChanceQueryCondition();
//        chanceQueryCondition.setProductNum("SAP");
//        List<ChanceTypeProduct> list = chanceTypeProductService.getItemsByChanceAndProduct(chanceQueryCondition);
//        for (ChanceTypeProduct a:list) System.out.println(a);
//    }
    @Autowired
    IUserService iUserService;

    @Test
    void teest() {
        System.out.println(iUserService.list().get(0));
    }

}
