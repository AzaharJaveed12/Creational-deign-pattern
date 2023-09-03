/*
   NAME - this field is formed by combining the two fields of UserEntity. (FirstName and LastName)
   ADDRESS - this field is formed by combining all the fields of Address Object.
   AGE - This should be calculated from DOB of user.

   --> UserWebDTO creation requires Address Object modifications and User Object modification.
       If we ask client to make this complex object creation then they will fed up.

       Can overcome by using Builder Design pattern.
 */

public class UserWebDTO implements UserDTO{
    private String name;
    private String address;
    private String age;
    @Override
    public String getName() {
        return name;
    }

    public UserWebDTO(String name, String address, String age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "UserWebDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
