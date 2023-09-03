
/*
this is the DTO which is implemented by PRODUCT which we are aiming to build object using
builder design pattern.

 INTERFACES ACCESS MODIFIERS ARE BY DEFAULT PUBLIC NO NEED TO DECALRE EXPLICITELY.
 INTERFACES CANT HAVE VARIABLES AS INTERFACES IN JAVE ARE STATIC FINAL BY DEFAULT. WE CANT MODIFY THEM.
 */
public interface UserDTO {
    String getName();
    String getAddress();
    String getAge();
}
