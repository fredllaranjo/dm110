package br.inatel.fredlaranjo.dm110.poller.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.inatel.fredlaranjo.dm110.poller.core.PollerServiceImpl;

@ApplicationPath("/rest")
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(PollerServiceImpl.class);
		return classes;
	}

}
