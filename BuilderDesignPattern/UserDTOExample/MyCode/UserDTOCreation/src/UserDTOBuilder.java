import java.time.LocalDate;

public interface UserDTOBuilder {
    UserDTOBuilder withFirstName(String firstName);
    UserDTOBuilder withLastName(String lastName);
    UserDTOBuilder withDOB(LocalDate DOB);
    UserDTOBuilder withAddress(Address address);

    UserDTO build();
}
