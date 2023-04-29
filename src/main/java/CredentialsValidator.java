import java.util.List;

public class CredentialsValidator {

    public CredentialsValidator() {
    }

    private boolean isFirstNameValid(String credential){
        String regex = "^[a-zA-Z]([a-zA-Z]|[-'](?=[^-']))*[a-zA-Z]$";
        return credential.matches(regex);
    }

    private boolean isLastNameValid(String credential){
        String regex = "[a-zA-Z]([a-zA-Z]|[-' ](?=[^-' ]))*[a-zA-Z]$";
        return credential.matches(regex);
    }

    private boolean isEmailValid(String credential){
        String regex = "^[a-zA-Z0-9.!#$%&'*+/=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)+$";
        return credential.matches(regex);
    }

    public boolean isValidStudent(List<String> nameLastNameAndEmail) {
        String firstName = nameLastNameAndEmail.get(0);
        String email = nameLastNameAndEmail.get(2);
        String lastName = nameLastNameAndEmail.get(1);


        boolean isFirstNameValid = isFirstNameValid(firstName);
        boolean isEmailValid = isEmailValid(email);
        boolean isLastNameValid = isLastNameValid(lastName);

        if (!isFirstNameValid){
            System.out.println("Incorrect first name.");
            return false;
        }
        else if (!isEmailValid){
            System.out.println("Incorrect email");
            return false;
        }
        else if (!isLastNameValid){
            System.out.println("Incorrect last name");
            return false;
        }

        return true;
    }

}
