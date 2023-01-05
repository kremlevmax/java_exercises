package org.maxkremlev;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.maxkremlev")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfiguration {
}
