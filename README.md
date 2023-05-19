# Wildapricot Wrapper for Java and Kotlin

### Caution: This is currently a work in progress, and it is not stable yet, please take care of that in your projects.

Creating this wrapper as an open-source project, to help the community, who are looking for a well structured package for their daily needs of interactive with the wildapricot API.

The motivation behind this project is to solve the current problem that i am having at our organization and another is to try and help the community if i can do so.

This is sort of a side project for me, but will be maintaining it.

Currently this is in alpha, stage, manual testing is being done on it, and new endpoints are continuously being added into the package.

Main Goals for it to be stable
1. At least 40% of the endpoints covered
2. Complete testing for each part of the codebase
3. Support all authentication / authorization workflows.

If any of you guys feel like there is an error, or some stuff can be improved or changed, please free to create an issue or a PR as you like, eventually this would help the project grow and move forward at a faster pace.

Right now, the only mode of authentication, i.e API KEY authentication is available to be used.

### Usage

1. Getting Started
```
<dependency>
   <groupId>com.the-mgi</groupId>
   <artifactId>wildapricot-wrapper</artifactId>
   <version>0.1</version>
</dependency>
```

2. For Account's service
```
   WildApricot wildApricot = new WildApricot.Builder()
            .authOption(AuthenticationOption.USING_API_KEY)
            .apiKey("xxxxxxxxxxxxxxx")
            .build();

        List<Account> accounts = wildApricot
            .getAccountService()
            .getAllAccounts();

        Account account = wildApricot
            .getAccountService()
            .getAccountDetails(xxxxxxx);
```

3. For Contact's Service
    <p>As we're aware that WildApricot keep fields of a contact in the form of an array, so to efficiently tackle that you can use the custom annotations provided by this package i.e @FieldValue, @JsonSerializable, and then you can use that in the following way, with the class models.</p>
the properties annotated w/ @JsonProperty are directly being de-serialized from JSON object, whereas the ones with @FieldValue are being found out from the list of FieldValues and are then being assigned.
```
public class YourContactDetails {
    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Email")
    private String emailAddress;

    @JsonProperty("IsAccountAdministrator")
    private Boolean isAccountAdministrator;

    @JsonProperty("Status")
    private String status;

    @FieldValue(key = "NestedValue", nestedValueKey = "Label")
    private String nestedValue;

    @FieldValue(key = "Employer's Name")
    private String employersName;

    @FieldValue(key = "Middle Name")
    private String middleName;

    @FieldValue(key = "Mailing Address")
    private String mailingAddress;

    @FieldValue(key = "Mailing City")
    private String mailingCity;

    @FieldValue(key = "Mailing State")
    private String mailingState;

    @FieldValue(key = "Mailing Zip")
    private String mailingZip;

    @FieldValue(key = "Mailing Country")
    private String mailingCountry;

    @FieldValue(key = "Notes")
    private String homePhone;
}
```
```
    WildApricot wildApricot = new WildApricot.Builder()
            .authOption(AuthenticationOption.USING_API_KEY)
            .apiKey("xxxxxxxxxxxxxxx")
            .build();

        ContactExtendedMembershipInfo info = wildApricot
            .getContactService()
            .getInformationAboutContact(xxxx, xxxx);

        YourContactDetails details = wildApricot
            .getContactService()
            .getInformationAboutContactParsed(xxxx, xxxx, false, YourContactDetails.class);
```

## Happy Coding 🎉🎉