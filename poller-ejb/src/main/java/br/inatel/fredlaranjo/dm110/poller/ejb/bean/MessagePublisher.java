package br.inatel.fredlaranjo.dm110.poller.ejb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import br.inatel.fredlaranjo.dm110.poller.ejb.entity.PollerMessage;

@Stateless
public class MessagePublisher {

	@Resource(lookup = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/jms/queue/dm110pollerqueue")
	private Queue queue;

	public void sendMessage(List<String> ips) {
		try (Connection connection = connectionFactory.createConnection();
				Session session = connection.createSession();
				MessageProducer producer = session.createProducer(queue);) {
			PollerMessage pollerMessage = new PollerMessage(new ArrayList<String>(ips));
			ObjectMessage objMessage = session.createObjectMessage(pollerMessage);
			producer.send(objMessage);
			System.out.println("Mensagem enviada para ips: " + ips.toString());
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

}
