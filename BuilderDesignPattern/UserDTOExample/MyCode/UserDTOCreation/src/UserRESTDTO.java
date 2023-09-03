/*

Lets assume that the calcualation of name and address is different for this DTO compare to
userWebDTOBuilder.

THIS IS PERFECT EXAMPLE OF BUILDER DESIGN PATTERN. (INNER CLASS TO BUILD THIS CLASS )S
 */

import java.time.LocalDate;
import java.time.Period;

public class UserRESTDTO implements UserDTO {
    private String name;
    private String address;
    private String age;
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public String getAge() {
        return this.age;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    private void setAge(String age) {
        this.age = age;
    }

    public static UserDTOBuilder getUserRESTDTOBuilder() {
        return new UserRESTDTOBuilder();
    }
    public static class UserRESTDTOBuilder implements UserDTOBuilder {
        private String firstName;
        private String lastName;
        private String age;
        private String  address;

        /*
         THIS SHOULD BE OF OUTERCLASS NAME ONLY. IF I USE ABSTRACT INTERFACE NAME WE WILL GET ERROR
         AS ABSTRACT INTERFACE DIDNT HAVE THAT FIELDS WHICH WE ARE TRYING TO SET.

         moreover we are creating object of outer-class, we are not directly accessing non-static methods here.
         */

        private UserRESTDTO userRESTDTO;

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
            this.age = Integer.toString(Period.between(DOB,LocalDate.now()).getYears());
            return this;
        }

        @Override
        public UserDTOBuilder withAddress(Address address) {
            this.address = address.getArea() + "," +address.getCity() + "," + address.getPinCode();
            return this;
        }

        @Override
        public UserDTO build() {
            this.userRESTDTO = new UserRESTDTO();
            userRESTDTO.setName(firstName + "," + lastName);
            userRESTDTO.setAddress(this.address);
            userRESTDTO.setAge(this.age);

            return userRESTDTO;
        }
    }
}