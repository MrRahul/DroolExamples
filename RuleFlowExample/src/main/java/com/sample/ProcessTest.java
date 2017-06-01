package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import com.sample.Message;

/**
 * This is a sample file to launch a process.
 */
public class ProcessTest {

	public static final void main(String[] args) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");
			
			Message message = new Message();
			message.setMessage("Hello World");
			message.setStatus(Message.HELLO);
			System.out.println("\nRULE ENGINE STARTED\n");
			kSession.insert(message);
			
			//invoking the rule flow
			kSession.startProcess("hello");
			kSession.fireAllRules();
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
