package com.techiekernel.rest;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.techiekernel.service.FooBarService;

@Component
@Path("/foobar")
public class FooBarWS {
	FooBarService fooBarService;
 
	@GET
	@Path("/{param}")
	public Response getMessage(@PathParam("param") String msg, @Context ServletContext servletContext) {
		//get Spring application context
				ApplicationContext ctx = 
		                     WebApplicationContextUtils.getWebApplicationContext(servletContext);
				fooBarService= ctx.getBean("FooBar",FooBarService.class);
		return Response.status(200).entity(fooBarService.getMessage(msg)).build();
	}
}
