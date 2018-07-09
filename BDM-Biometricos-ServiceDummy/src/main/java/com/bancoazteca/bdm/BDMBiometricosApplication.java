/**
 * 
 */
package com.bancoazteca.bdm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author ajcruzmi
 *
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration(exclude = { AopAutoConfiguration.class })
@EnableDiscoveryClient
public class BDMBiometricosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BDMBiometricosApplication.class, args);
	}
}
