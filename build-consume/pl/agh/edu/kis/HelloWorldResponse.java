
package pl.agh.edu.kis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HelloWorldResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HelloWorldResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HelloElement" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HelloWorldResponse", propOrder = {
    "helloElement"
})
public class HelloWorldResponse {

    @XmlElement(name = "HelloElement")
    protected String helloElement;

    /**
     * Gets the value of the helloElement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHelloElement() {
        return helloElement;
    }

    /**
     * Sets the value of the helloElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHelloElement(String value) {
        this.helloElement = value;
    }

}
