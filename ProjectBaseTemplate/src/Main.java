import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.gflex.template.processor.IProcessor;
import br.com.gflex.template.processor.impl.RepositoryImplProcessor;
import br.com.gflex.template.processor.impl.RepositoryProcessor;
import br.com.gflex.template.processor.impl.ServiceImplProcessor;
import br.com.gflex.template.vo.AttributeTemplate;
import br.com.gflex.template.vo.InterfaceTemplate;
import br.com.gflex.template.vo.VOTemplate;

public class Main
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		InterfaceTemplate interfaceRepository = createInterfaceRepository();
		VOTemplate classRepository = createClassRepository();

		InterfaceTemplate interfaceService = createInterfaceService();
		VOTemplate classService = createClassService();

		VOTemplate classVO = createClassVO();
		IProcessor repositoryProcessor = new ServiceImplProcessor(classService, interfaceService,
				interfaceRepository, classVO);

		String returnGenerate = repositoryProcessor.generate();
		System.out.println(returnGenerate);
	}

	private static VOTemplate createClassService()
	{
		VOTemplate classService = new VOTemplate();
		classService.setName("UserServiceImpl");
		classService.setPackageName("br.com.gflex.service.impl");

		return classService;
	}

	private static VOTemplate createClassRepository()
	{
		VOTemplate classRepository = new VOTemplate();
		classRepository.setName("UserRepositoryImpl");
		classRepository.setPackageName("br.com.gflex.repository.impl");

		return classRepository;
	}

	private static InterfaceTemplate createInterfaceRepository()
	{
		InterfaceTemplate interfaceRepository = new InterfaceTemplate();
		interfaceRepository.setName("IUserRepository");
		interfaceRepository.setPackageName("br.com.gflex.repository");

		return interfaceRepository;
	}

	private static VOTemplate createClassVO()
	{
		VOTemplate classVO = new VOTemplate();
		classVO.setName("UserVO");
		classVO.setPackageName("br.com.gflex.vo");
		classVO.setTypePk("Long");

		List<AttributeTemplate> attributes = new ArrayList<AttributeTemplate>();

		AttributeTemplate attributeTemplate1 = new AttributeTemplate();
		attributeTemplate1.setName("code");
		attributeTemplate1.setType("Long");

		AttributeTemplate attributeTemplate2 = new AttributeTemplate();
		attributeTemplate2.setName("name");
		attributeTemplate2.setType("String");

		AttributeTemplate attributeTemplate3 = new AttributeTemplate();
		attributeTemplate3.setName("login");
		attributeTemplate3.setType("String");

		AttributeTemplate attributeTemplate4 = new AttributeTemplate();
		attributeTemplate4.setName("password");
		attributeTemplate4.setType("String");

		attributes.add(attributeTemplate1);
		attributes.add(attributeTemplate2);
		attributes.add(attributeTemplate3);
		attributes.add(attributeTemplate4);

		classVO.setAttributes(attributes);

		return classVO;
	}

	private static InterfaceTemplate createInterfaceService()
	{
		InterfaceTemplate interfaceService = new InterfaceTemplate();
		interfaceService.setName("IUserService");
		interfaceService.setPackageName("br.com.gflex.service");

		return interfaceService;
	}

}
