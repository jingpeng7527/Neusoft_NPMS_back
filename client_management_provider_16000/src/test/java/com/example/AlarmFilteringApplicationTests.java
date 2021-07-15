package com.example;//package com.neu.af;

import com.baomidou.mybatisplus.extension.api.R;

import com.example.client_management_provider_16000.dto.QueryClientPara;
import com.example.client_management_provider_16000.entity.ClientRelate;
import com.example.client_management_provider_16000.mapper.ClientMapper;
import com.example.client_management_provider_16000.mapper.ClientRelateMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class AlarmFilteringApplicationTests {

    @Autowired
    ClientMapper clientMapper;
    @Autowired
    ClientRelateMapper clientRelateMapper;

    @Test
    void testUpdate() {
//        QueryClientPara p = new QueryClientPara();
//        p.setClientName("e");
//        p.setDeptId(null);
//        p.setDeptId(2);
//        p.setClientNum("80000");
//        System.out.println(clientMapper.queryClient(p));
        ClientRelate clientRelate = new ClientRelate();
        clientRelate.setClientRelateId(2);
        clientRelate.setClientCurrentId(1);
        clientRelate.setClientRelateTypeId(2);
        System.out.println(clientRelateMapper.getSaveRelate(clientRelate));
         }
}