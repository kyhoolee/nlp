package com.minzai.nlp.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class NlpApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public NlpApplication() {
		singletons.add(new NlpResource());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
