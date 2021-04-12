package business;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import beans.Order;
import database.OrdersDataInterface;

/**
 * Message-Driven Bean implementation class for: OrderMessageService
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:/jms/queue/Order"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:/jms/queue/Order")
public class OrderMessageService implements MessageListener {

	@Inject
	OrdersDataInterface service;
    /**
     * Default constructor. 
     */
    public OrderMessageService() {
        // TODO Auto-generated constructor stub   	
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        try {
        	//If a text message then print it to console, otherwise if its an object then insert Order to database using DAO service
        	if(message instanceof TextMessage) 
        	{
        		System.out.println("==============> OrderMessageService.onMessgae() with a text message: " + ((TextMessage)message).getText());
        	}else if(message instanceof ObjectMessage) 
        	{
        		System.out.println("==============> OrderMessageService.onMessgae() with a send order message.");  
        		service.create((Order)((ObjectMessage)message).getObject());
        	}
        }
        catch(JMSException e) {
        	
        }
    }

}
