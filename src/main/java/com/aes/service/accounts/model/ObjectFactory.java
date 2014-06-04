
package com.aes.service.accounts.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.aes.service.accounts.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.aes.service.accounts.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreditCard }
     * 
     */
    public CreditCard createCreditCard() {
        return new CreditCard();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link Transport }
     * 
     */
    public Transport createTransport() {
        return new Transport();
    }

    /**
     * Create an instance of {@link CancelProcess }
     * 
     */
    public CancelProcess createCancelProcess() {
        return new CancelProcess();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link StartProcess }
     * 
     */
    public StartProcess createStartProcess() {
        return new StartProcess();
    }

    /**
     * Create an instance of {@link Lodging }
     * 
     */
    public Lodging createLodging() {
        return new Lodging();
    }

}
