package utilities;

import error.InvalidInputException;
import model.Student;

import java.util.List;

public class CredentialsValidator {

    private boolean isFirstNameValid(String credential){
        String regex = "^[a-zA-Z]([a-zA-Z]|[-'](?=[^-']))*[a-zA-Z]$";
        return credential.matches(regex);
    }

    private boolean isLastNameValid(String credential){
        String regex = "[a-zA-Z]([a-zA-Z]|[-' ](?=[^-' ]))*[a-zA-Z]$";
        return credential.matches(regex);
    }

    private boolean isEmailValid(String credential){
        String regex = "^[a-zA-Z\\d.!#$%&'*+/=? ^_`{|}~-]+@[a-zA-Z\\d-]+(?:\\.[a-zA-Z\\d-]+)+$";
        return credential.matches(regex);
    }

    public Student isValidStudent(List<String> nameLastNameAndEmail) throws InvalidInputException {
        String firstName = nameLastNameAndEmail.get(0);
        String email = nameLastNameAndEmail.get(2);
        String lastName = nameLastNameAndEmail.get(1);


        boolean isFirstNameValid = isFirstNameValid(firstName);
        boolean isEmailValid = isEmailValid(email);
        boolean isLastNameValid = isLastNameValid(lastName);

        if (!isFirstNameValid){
            throw new InvalidInputException("Incorrect first name.");
        }
        else if (!isEmailValid){
            throw new InvalidInputException("Incorrect email");
        }
        else if (!isLastNameValid){
            throw new InvalidInputException("Incorrect last name");
        }

        return new Student(firstName, lastName, email);
    }

}
