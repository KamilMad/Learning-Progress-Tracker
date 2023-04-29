package services;

import error.InvalidInputException;
import model.Student;
import utilities.CredentialExtractor;
import utilities.CredentialsValidator;

import java.util.List;

public class StudentService {

    private static final CredentialsValidator validator = new CredentialsValidator();

    public Student addStudent(String input) throws InvalidInputException {
        return parse(input);
    }

    public Student parse(String input) throws InvalidInputException {
        List<String> nameLastNameAndEmail = new CredentialExtractor().extractCredentials(input.trim());

        if (nameLastNameAndEmail == null){
            throw new InvalidInputException("Incorrect credentials");
        }

        return validator.isValidStudent(nameLastNameAndEmail);
    }

}
