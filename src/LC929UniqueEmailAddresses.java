import java.util.HashSet;
import java.util.Set;

public class LC929UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (int i = 0; i < emails.length; i++) {
            String email = emails[i];

            String[] names = email.split("@");
            String localName = names[0];
            String domainName = names[1];

            if (localName.contains("+")) {
                localName = localName.substring(0, localName.indexOf("+"));
            }

            if (localName.contains(".")) {
                localName = localName.replaceAll("\\.", "");
            }

            String newEmail = localName + "@" + domainName;

            uniqueEmails.add(newEmail);
        }

        return uniqueEmails.size();
    }
}
