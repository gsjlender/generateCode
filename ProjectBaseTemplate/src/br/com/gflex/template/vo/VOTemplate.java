package br.com.gflex.template.vo;

import java.util.List;

public class VOTemplate
{
	private String name;
	private String packageName;
	private String typePk;
	private List<AttributeTemplate> attributes;

	/**
	 * @return the attributes
	 */
	public List<AttributeTemplate> getAttributes()
	{
		return attributes;
	}

	/**
	 * @param attributes
	 *            the attributes to set
	 */
	public void setAttributes(List<AttributeTemplate> attributes)
	{
		this.attributes = attributes;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the packageName
	 */
	public String getPackageName()
	{
		return packageName;
	}

	/**
	 * @param packageName
	 *            the packageName to set
	 */
	public void setPackageName(String packageName)
	{
		this.packageName = packageName;
	}

	/**
	 * @return the typePk
	 */
	public String getTypePk()
	{
		return typePk;
	}

	/**
	 * @param typePk
	 *            the typePk to set
	 */
	public void setTypePk(String typePk)
	{
		this.typePk = typePk;
	}
}
