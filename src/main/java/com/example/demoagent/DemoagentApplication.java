package com.example.demoagent;

import com.example.demoagent.service.OrderMcpServerService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoagentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoagentApplication.class, args);
	}

	@Bean
	public ToolCallbackProvider orderTools(OrderMcpServerService orderMcpServerService){
		return  MethodToolCallbackProvider.builder().toolObjects(orderMcpServerService).build();
	}
}
