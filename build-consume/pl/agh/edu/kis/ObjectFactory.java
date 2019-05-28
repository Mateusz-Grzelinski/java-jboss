
package pl.agh.edu.kis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.agh.edu.kis package. 
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

    private final static QName _HelloSecret_QNAME = new QName("http://kis.edu.agh.pl/", "HelloSecret");
    private final static QName _HelloSecretResponse_QNAME = new QName("http://kis.edu.agh.pl/", "HelloSecretResponse");
    private final static QName _HelloStudent_QNAME = new QName("http://kis.edu.agh.pl/", "HelloStudent");
    private final static QName _HelloStudentResponse_QNAME = new QName("http://kis.edu.agh.pl/", "HelloStudentResponse");
    private final static QName _HelloWorld_QNAME = new QName("http://kis.edu.agh.pl/", "HelloWorld");
    private final static QName _HelloWorldResponse_QNAME = new QName("http://kis.edu.agh.pl/", "HelloWorldResponse");
    private final static QName _CreateStudent_QNAME = new QName("http://kis.edu.agh.pl/", "createStudent");
    private final static QName _CreateStudentResponse_QNAME = new QName("http://kis.edu.agh.pl/", "createStudentResponse");
    private final static QName _GetAllStudents_QNAME = new QName("http://kis.edu.agh.pl/", "getAllStudents");
    private final static QName _GetAllStudentsResponse_QNAME = new QName("http://kis.edu.agh.pl/", "getAllStudentsResponse");
    private final static QName _GetStudent_QNAME = new QName("http://kis.edu.agh.pl/", "getStudent");
    private final static QName _GetStudentResponse_QNAME = new QName("http://kis.edu.agh.pl/", "getStudentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.agh.edu.kis
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse }
     * 
     */
    public GetAllStudentsResponse createGetAllStudentsResponse() {
        return new GetAllStudentsResponse();
    }

    /**
     * Create an instance of {@link HelloSecretResponse }
     * 
     */
    public HelloSecretResponse createHelloSecretResponse() {
        return new HelloSecretResponse();
    }

    /**
     * Create an instance of {@link HelloSecret }
     * 
     */
    public HelloSecret createHelloSecret() {
        return new HelloSecret();
    }

    /**
     * Create an instance of {@link HelloStudent }
     * 
     */
    public HelloStudent createHelloStudent() {
        return new HelloStudent();
    }

    /**
     * Create an instance of {@link HelloStudentResponse }
     * 
     */
    public HelloStudentResponse createHelloStudentResponse() {
        return new HelloStudentResponse();
    }

    /**
     * Create an instance of {@link HelloWorld }
     * 
     */
    public HelloWorld createHelloWorld() {
        return new HelloWorld();
    }

    /**
     * Create an instance of {@link HelloWorldResponse }
     * 
     */
    public HelloWorldResponse createHelloWorldResponse() {
        return new HelloWorldResponse();
    }

    /**
     * Create an instance of {@link CreateStudent }
     * 
     */
    public CreateStudent createCreateStudent() {
        return new CreateStudent();
    }

    /**
     * Create an instance of {@link CreateStudentResponse }
     * 
     */
    public CreateStudentResponse createCreateStudentResponse() {
        return new CreateStudentResponse();
    }

    /**
     * Create an instance of {@link GetAllStudents }
     * 
     */
    public GetAllStudents createGetAllStudents() {
        return new GetAllStudents();
    }

    /**
     * Create an instance of {@link GetStudent }
     * 
     */
    public GetStudent createGetStudent() {
        return new GetStudent();
    }

    /**
     * Create an instance of {@link GetStudentResponse }
     * 
     */
    public GetStudentResponse createGetStudentResponse() {
        return new GetStudentResponse();
    }

    /**
     * Create an instance of {@link Student.SubjectList }
     * 
     */
    public Student.SubjectList createStudentSubjectList() {
        return new Student.SubjectList();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse.StudentList }
     * 
     */
    public GetAllStudentsResponse.StudentList createGetAllStudentsResponseStudentList() {
        return new GetAllStudentsResponse.StudentList();
    }

    /**
     * Create an instance of {@link HelloSecretResponse.ElementsWrapper }
     * 
     */
    public HelloSecretResponse.ElementsWrapper createHelloSecretResponseElementsWrapper() {
        return new HelloSecretResponse.ElementsWrapper();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloSecret }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloSecret }{@code >}
     */
    @XmlElementDecl(namespace = "http://kis.edu.agh.pl/", name = "HelloSecret")
    public JAXBElement<HelloSecret> createHelloSecret(HelloSecret value) {
        return new JAXBElement<HelloSecret>(_HelloSecret_QNAME, HelloSecret.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloSecretResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloSecretResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://kis.edu.agh.pl/", name = "HelloSecretResponse")
    public JAXBElement<HelloSecretResponse> createHelloSecretResponse(HelloSecretResponse value) {
        return new JAXBElement<HelloSecretResponse>(_HelloSecretResponse_QNAME, HelloSecretResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://kis.edu.agh.pl/", name = "HelloStudent")
    public JAXBElement<HelloStudent> createHelloStudent(HelloStudent value) {
        return new JAXBElement<HelloStudent>(_HelloStudent_QNAME, HelloStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://kis.edu.agh.pl/", name = "HelloStudentResponse")
    public JAXBElement<HelloStudentResponse> createHelloStudentResponse(HelloStudentResponse value) {
        return new JAXBElement<HelloStudentResponse>(_HelloStudentResponse_QNAME, HelloStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWorld }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloWorld }{@code >}
     */
    @XmlElementDecl(namespace = "http://kis.edu.agh.pl/", name = "HelloWorld")
    public JAXBElement<HelloWorld> createHelloWorld(HelloWorld value) {
        return new JAXBElement<HelloWorld>(_HelloWorld_QNAME, HelloWorld.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloWorldResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HelloWorldResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://kis.edu.agh.pl/", name = "HelloWorldResponse")
    public JAXBElement<HelloWorldResponse> createHelloWorldResponse(HelloWorldResponse value) {
        return new JAXBElement<HelloWorldResponse>(_HelloWorldResponse_QNAME, HelloWorldResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://kis.edu.agh.pl/", name = "createStudent")
    public JAXBElement<CreateStudent> createCreateStudent(CreateStudent value) {
        return new JAXBElement<CreateStudent>(_CreateStudent_QNAME, CreateStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://kis.edu.agh.pl/", name = "createStudentResponse")
    public JAXBElement<CreateStudentResponse> createCreateStudentResponse(CreateStudentResponse value) {
        return new JAXBElement<CreateStudentResponse>(_CreateStudentResponse_QNAME, CreateStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}
     */
    @XmlElementDecl(namespace = "http://kis.edu.agh.pl/", name = "getAllStudents")
    public JAXBElement<GetAllStudents> createGetAllStudents(GetAllStudents value) {
        return new JAXBElement<GetAllStudents>(_GetAllStudents_QNAME, GetAllStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://kis.edu.agh.pl/", name = "getAllStudentsResponse")
    public JAXBElement<GetAllStudentsResponse> createGetAllStudentsResponse(GetAllStudentsResponse value) {
        return new JAXBElement<GetAllStudentsResponse>(_GetAllStudentsResponse_QNAME, GetAllStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://kis.edu.agh.pl/", name = "getStudent")
    public JAXBElement<GetStudent> createGetStudent(GetStudent value) {
        return new JAXBElement<GetStudent>(_GetStudent_QNAME, GetStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://kis.edu.agh.pl/", name = "getStudentResponse")
    public JAXBElement<GetStudentResponse> createGetStudentResponse(GetStudentResponse value) {
        return new JAXBElement<GetStudentResponse>(_GetStudentResponse_QNAME, GetStudentResponse.class, null, value);
    }

}
