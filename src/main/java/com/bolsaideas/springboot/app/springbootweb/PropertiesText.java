package com.bolsaideas.springboot.app.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:texts.properties")
})
public class PropertiesText {

}
