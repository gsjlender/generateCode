package br.com.gflex.template.processor.impl;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import br.com.gflex.template.processor.IProcessor;
import br.com.gflex.template.vo.InterfaceTemplate;
import br.com.gflex.template.vo.VOTemplate;

public class ServiceImplProcessor implements IProcessor
{

	private VOTemplate classService;
	private InterfaceTemplate interfaceService;
	private InterfaceTemplate interfaceRepository;
	private VOTemplate classVO;

	public ServiceImplProcessor(VOTemplate classService, InterfaceTemplate interfaceService,
			InterfaceTemplate interfaceRepository, VOTemplate classVO)
	{
		this.classService = classService;
		this.interfaceService = interfaceService;
		this.interfaceRepository = interfaceRepository;
		this.classVO = classVO;
	}

	@Override
	public String generate()
	{
		Velocity.init();

		VelocityContext context = new VelocityContext();
		context.put("classService", classService);
		context.put("interfaceService", interfaceService);
		context.put("interfaceRepository", interfaceRepository);
		context.put("classVO", classVO);

		StringWriter writer = new StringWriter();
		Template template = Velocity.getTemplate("templates/service-impl-template.vm");

		if (template != null)
			template.merge(context, writer);

		return writer.toString();
	}

}
