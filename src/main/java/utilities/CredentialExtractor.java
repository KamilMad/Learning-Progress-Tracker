package utilities;

import java.util.Arrays;
import java.util.List;

public class CredentialExtractor {
    public List<String> extractCredentials(String credentials){
        String[] splitCredentials = credentials.split(" ");

        if (splitCredentials.length < 3){
            return null;
        }

        int arrayLength = splitCredentials.length;
        String email = splitCredentials[arrayLength-1];

        String firstName = splitCredentials[0];

        String lastName = String.join(" ", Arrays.copyOfRange(splitCredentials,1,arrayLength-1));

        return List.of(firstName, lastName , email);
    }
}
