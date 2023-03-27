package com.example.springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Hashtable;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {
		File a = new File("/usr/local/bin/geeks");
		createDir(a);
		SpringApplication.run(SpringProjectApplication.class, args);
	}
	public static void createDir(File dir) {
		if (dir != null || !dir.exists()) // BAD
			dir.mkdir();
	}

	public void jndiLookup(HttpServletRequest request) throws NamingException {
		String name = request.getParameter("name");

		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
		env.put(Context.PROVIDER_URL, "rmi://trusted-server:1099");
		InitialContext ctx = new InitialContext(env);

		// BAD: User input used in lookup
		ctx.lookup(name);

	}

}
