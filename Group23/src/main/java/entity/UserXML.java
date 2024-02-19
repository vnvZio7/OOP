package entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserXML {

    private List<User> user;

    public List<User> getStudent() {
        return user;
    }

    public void setStudent(List<User> users) {
        this.user = users;
    }
}