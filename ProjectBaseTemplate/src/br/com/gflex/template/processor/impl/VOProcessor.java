package br.com.gflex.template.processor.impl;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import br.com.gflex.template.processor.IProcessor;
import br.com.gflex.template.vo.VOTemplate;

public class VOProcessor implements IProcessor
{
	private VOTemplate classVO;
	
	public VOProcessor(VOTemplate classVO)
	{
		this.classVO = classVO;
	}

	@Override
	public String generate()
	{
		Velocity.init();

		VelocityContext context = new VelocityContext();
		context.put("classVO", this.classVO);

		StringWriter writer = new StringWriter();
		Template template = Velocity.getTemplate("templates/vo-template.vm");

		if (template != null)
			template.merge(context, writer);

		return writer.toString();
	}

}
