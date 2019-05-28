
package pl.agh.edu.kis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HelloStudentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HelloStudentResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HelloStudent" type="{http://kis.edu.agh.pl/}student" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HelloStudentResponse", propOrder = {
    "helloStudent"
})
public class HelloStudentResponse {

    @XmlElement(name = "HelloStudent")
    protected Student helloStudent;

    /**
     * Gets the value of the helloStudent property.
     * 
     * @return
     *     possible object is
     *     {@link Student }
     *     
     */
    public Student getHelloStudent() {
        return helloStudent;
    }

    /**
     * Sets the value of the helloStudent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Student }
     *     
     */
    public void setHelloStudent(Student value) {
        this.helloStudent = value;
    }

}
