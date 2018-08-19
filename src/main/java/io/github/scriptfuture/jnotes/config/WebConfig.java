package io.github.scriptfuture.jnotes.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("io.github.scriptfuture.jnotes")
public class WebConfig extends WebMvcConfigurerAdapter{
}
