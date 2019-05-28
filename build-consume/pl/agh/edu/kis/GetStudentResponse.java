
package pl.agh.edu.kis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStudentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStudentResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="studentGet" type="{http://kis.edu.agh.pl/}student" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStudentResponse", propOrder = {
    "studentGet"
})
public class GetStudentResponse {

    protected Student studentGet;

    /**
     * Gets the value of the studentGet property.
     * 
     * @return
     *     possible object is
     *     {@link Student }
     *     
     */
    public Student getStudentGet() {
        return studentGet;
    }

    /**
     * Sets the value of the studentGet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Student }
     *     
     */
    public void setStudentGet(Student value) {
        this.studentGet = value;
    }

}
