import error.InvalidInputException;

import java.util.List;

public class StudentParser {
    private static final CredentialsValidator validator = new CredentialsValidator();

    public Student parse(String input) throws InvalidInputException {
        List<String> nameLastNameAndEmail = new CredentialExtractor().extractCredentials(input.trim());

        if (nameLastNameAndEmail == null){
            throw new InvalidInputException("Incorrect credentials");
        }

        return validator.isValidStudent(nameLastNameAndEmail);
    }

}
