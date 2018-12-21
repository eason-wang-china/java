package com.eason.cloud.controller;

import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private DiscoveryClient client;

	@RequestMapping("/")
	public String index() {

		long start = System.currentTimeMillis();
		
		//System.out.println(client.getLocalServiceInstance().getServiceId());
		
		List<ServiceInstance> list = client.getInstances("spring-cloud-service-1");
		System.out.println(list.size());
		if (list != null && list.size() > 0) {

			System.out.println(list.get(0).getUri());
		}

		List<String> services = client.getServices();
		System.out.println("discoveryClient.getServices().size() = " + services.size());

		for (String s : services) {

			System.out.println("services " + s);

			List<ServiceInstance> serviceInstances = client.getInstances(s);
			for (ServiceInstance si : serviceInstances) {
				System.out.println("    services:" + s + ":getInstanceId()=" + si.getInstanceId());
				System.out.println("    services:" + s + ":getHost()=" + si.getHost());
				System.out.println("    services:" + s + ":getPort()=" + si.getPort());
				System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());
				System.out.println("    services:" + s + ":getUri()=" + si.getUri());
				System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());
				
				for (Entry<String, String> map : si.getMetadata().entrySet()) {
					System.out.println("    	metadata:" + s + ":key=" + map.getKey() + ":value=" + map.getValue());
				}
			}
		}

		return "{ result: hello world!   use: " + (System.currentTimeMillis() - start) + " }";
	}
}
