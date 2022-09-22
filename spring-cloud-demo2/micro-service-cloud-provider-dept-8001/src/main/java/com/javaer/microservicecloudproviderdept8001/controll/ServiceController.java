package com.javaer.microservicecloudproviderdept8001.controll;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/getservices")
public class ServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/getServicesList")
    public Object getServicesList() {
        List<List<ServiceInstance>> servicesList = new ArrayList<>();

        //获取服务名称
        List<String> serviceNames = discoveryClient.getServices();
        for (String serviceName : serviceNames) {
            //获取服务中的实例列表
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);

            servicesList.add(serviceInstances);

        }

//        JSONArray jsonArray = new JSONArray(Collections.singletonList(servicesList));
//
//        System.out.println("------>" + jsonArray.toString());

        return servicesList;
    }
}
