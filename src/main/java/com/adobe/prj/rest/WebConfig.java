package com.adobe.prj.rest;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration	 
@ComponentScan({ "com.adobe.prj" })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true).
		favorParameter(true).
		parameterName("mediaType"). 
		ignoreAcceptHeader(true).useJaf(false)
				.defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML)
				.mediaType("json", MediaType.APPLICATION_JSON);
	}

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		converters.add(createXmlHttpMessageConverter());
		MappingJackson2HttpMessageConverter jsonMapper = new MappingJackson2HttpMessageConverter();
		jsonMapper.setPrettyPrint(true);
		converters.add(jsonMapper);

		super.configureMessageConverters(converters);
	}

	private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
		MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
		// CastorMarshaller marshaller = new CastorMarshaller();
		XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
		xmlConverter.setMarshaller(xstreamMarshaller);
		xmlConverter.setUnmarshaller(xstreamMarshaller);
		return xmlConverter;
	}
}
