package br.com.gflex.template.processor.impl;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import br.com.gflex.template.processor.IProcessor;
import br.com.gflex.template.vo.InterfaceTemplate;
import br.com.gflex.template.vo.VOTemplate;

public class RepositoryImplProcessor implements IProcessor
{
	private VOTemplate classRepository;
	private InterfaceTemplate interfaceRepository;
	private VOTemplate classVO;

	public RepositoryImplProcessor(VOTemplate classRepository, InterfaceTemplate interfaceRepository,
			VOTemplate classVO)
	{
		this.classRepository = classRepository;
		this.interfaceRepository = interfaceRepository;
		this.classVO = classVO;
	}

	@Override
	public String generate()
	{
		Velocity.init();

		VelocityContext context = new VelocityContext();
		context.put("classRepository", classRepository);
		context.put("interfaceRepository", interfaceRepository);
		context.put("classVO", classVO);

		StringWriter writer = new StringWriter();
		Template template = Velocity.getTemplate("templates/repository-impl-template.vm");

		if (template != null)
			template.merge(context, writer);

		return writer.toString();
	}

}
