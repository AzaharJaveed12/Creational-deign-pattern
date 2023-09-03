import java.time.LocalDate;
import java.time.Period;

public class UserWebDTOBuilder implements UserDTOBuilder {
    private String firstName;
    private String lastName;
    private LocalDate DOB;
    private Address address;
    
    @Override
    public UserDTOBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public UserDTOBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public UserDTOBuilder withDOB(LocalDate DOB) {
        this.DOB = DOB;
        return this;
    }

    @Override
    public UserDTOBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    @Override
    public UserDTO build() {
        String name = this.firstName + this.lastName;
        String address = this.address.getArea() + "," + this.address.getCity() + "," + this.address.getPinCode();
        String DOB = Integer.toString(Period.between(this.DOB,LocalDate.now()).getYears());

        UserDTO userDTO = new UserWebDTO(name,address,DOB);

        return userDTO;
    }
}
