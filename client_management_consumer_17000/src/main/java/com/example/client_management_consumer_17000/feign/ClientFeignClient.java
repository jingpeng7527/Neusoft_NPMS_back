//package com.example.client_management_consumer_17000.feign;
//
//import com.example.client_management_consumer_17000.entity.Client;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@FeignClient(name="provider-server",fallback = ClientFeginClientCallBack.class)
//public interface ClientFeignClient {
//    //配置需要调用的挂号服务接口。与UserController中的方法定义一致
//    @GetMapping("/client_management_provider_16000/client/add")
//    public Client addClient(@PathVariable("userId") Integer userId);
//
//
//
//}
