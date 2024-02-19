package entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@XmlRootElement(name = "vaccine")
@XmlAccessorType(XmlAccessType.FIELD)
public class Vaccine {
    private int id;
    private String name;
    private double price;
    private Date vaccinDate = new Date();
    private Date injectAgain = new Date();

    public Vaccine() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Date getVaccinDate() {
        return vaccinDate;
    }

    public void setVaccinDate(Date vaccinDate) {
        this.vaccinDate = vaccinDate;
    }

    public Vaccine(int id, String name, double price, Date vaccinDate, Date injectAgain) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.vaccinDate = vaccinDate;
        this.injectAgain = injectAgain;
    }

    public Date getInjectAgain() {
        return injectAgain;
    }

    public void setInjectAgain(Date injectAgain) {
        this.injectAgain = injectAgain;
    }
}
