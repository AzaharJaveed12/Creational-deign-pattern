import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User  user = createUser();

        /*
        UserWebDTOBuilder userWebDTOBuilder = new UserWebDTOBuilder();
        UserDTO userWebDTO = Director(userWebDTOBuilder,user);
        System.out.println("Name: " + userWebDTO.getName() + "\nAddress : " + userWebDTO.getAddress() + "\nAge: W" + userWebDTO.getAge());
        */

        // THIS IS STANDARD WAY OF USING BUILDER DESIGN PATTERN.
        UserDTO userRESTDTO = Director(UserRESTDTO.getUserRESTDTOBuilder(),user);
        System.out.println("Name: " + userRESTDTO.getName() + "\nAddress : " + userRESTDTO.getAddress() + "\nAge: " + userRESTDTO.getAge());

    }

    private static  UserDTO Director(UserDTOBuilder userDTOBuilder, User user) {

        UserDTO userwebDTO = userDTOBuilder
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withAddress(user.getAddress())
                .withDOB(user.getBirthday())
                .build();

        return userwebDTO;
    }

    public static User createUser() {
        User user= new User();
        user.setFirstName("Javeed");
        user.setLastName("Shareef");
        user.setAddress(createAddress());
        user.setBirthday(LocalDate.of(1998,7,15));

        return user;
    }

    private static  Address createAddress() {
        Address address = new Address();
        address.setState("Telangana");
        address.setArea("Hyderabad");
        address.setPinCode("50008");
        address.setHouseNumber("XYZ");

        return address;
    }
}