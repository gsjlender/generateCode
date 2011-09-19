package br.com.gflex.template.processor.impl;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import br.com.gflex.template.processor.IProcessor;
import br.com.gflex.template.vo.InterfaceTemplate;
import br.com.gflex.template.vo.VOTemplate;

public class ServiceProcessor implements IProcessor
{

	private InterfaceTemplate interfaceService;
	private VOTemplate classVO;

	public ServiceProcessor(InterfaceTemplate interfaceService, VOTemplate classVO)
	{
		this.interfaceService = interfaceService;
		this.classVO = classVO;
	}

	@Override
	public String generate()
	{
		Velocity.init();

		VelocityContext context = new VelocityContext();
		context.put("interfaceService", interfaceService);
		context.put("classVO", classVO);

		StringWriter writer = new StringWriter();
		Template template = Velocity.getTemplate("templates/service-template.vm");

		if (template != null)
			template.merge(context, writer);

		return writer.toString();
	}

}
