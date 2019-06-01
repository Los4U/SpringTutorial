package tutorial.demo.entity;
import javax.persistence.*;

@Entity
@Table(name = "medicines", schema = "public")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    private int medicineId;

    @Column(name = "medicineCode")
    private int medicineCode;

    @Column(name = "medicineName")
    private String medicineName;

    @Column(name = "medicineDescription")
    private  String medicineDescription;

    public Medicine() {
    }

    public Medicine(int medicineCode, String medicineName, String medicineDescription) {
        this.medicineCode = medicineCode;
        this.medicineName = medicineName;
        this.medicineDescription = medicineDescription;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineId=" + medicineId +
                ", medicineCode=" + medicineCode +
                ", medicineName='" + medicineName + '\'' +
                ", medicineDescription='" + medicineDescription + '\'' +
                '}';
    }


    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public int getMedicineCode() {
        return medicineCode;
    }

    public void setMedicineCode(int medicineCode) {
        this.medicineCode = medicineCode;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineDescription() {
        return medicineDescription;
    }

    public void setMedicineDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }
}
