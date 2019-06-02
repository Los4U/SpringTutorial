package tutorial.demo.entity;

import tutorial.demo.Service.CourseCode;

import javax.validation.constraints.*;
import java.util.LinkedHashMap;

public class Student {

    @NotNull(message = "is required")
    @Size(min = 3, message = "to short")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "to short")
    private String lastName;

    @NotNull(message = "is required")
    @Size(min = 5, message = "to short")
    @Pattern(regexp = "^[0-9]{5}",message = "only 5 digits")
    private String postCode;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be >= 0")
    @Max(value = 10, message = "must be <= 10")
    private Integer freePasses;

    @NotNull(message = "is required")
    @CourseCode(value="LUV", message="must start with LUV")
    private String courseCode;



    private String country;

    private LinkedHashMap<String, String> countryOptions;

    public Student() {
        this.countryOptions = new LinkedHashMap<>();
        this.countryOptions.put("BR", "Brazil");
        this.countryOptions.put("GER", "German");
        this.countryOptions.put("PL", "Poland");
        this.countryOptions.put("USA", "America");

    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
        this.countryOptions = countryOptions;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }


}



