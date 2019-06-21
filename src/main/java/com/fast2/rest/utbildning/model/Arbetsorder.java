package com.fast2.rest.utbildning.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * jaxb annotation
 * @author Bassam Aldalati
 *
 */
@XmlRootElement(name = "arbetsorder")
public class Arbetsorder {
	  private long id;
	    private String name;

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }


}
