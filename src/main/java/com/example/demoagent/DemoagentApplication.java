package com.example.demoagent;

import com.example.demoagent.service.OrderMcpServerService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoagentApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DemoagentApplication.class);
		app.setBannerMode(Banner.Mode.OFF); // Disable ASCII banner
		app.run(args);
	}

	@Bean
	public ToolCallbackProvider orderTools(OrderMcpServerService orderMcpServerService){
		return  MethodToolCallbackProvider.builder().toolObjects(orderMcpServerService).build();
	}
}
