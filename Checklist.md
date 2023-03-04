- [x] Accounts
    - [x] `GET` List of available accounts
    - [x] `GET` Details of specific account


- [ ] Contacts
    - Base
        - [ ] `GET` Contact List
        - [ ] `POST` Create a new contact or member record
        - [x] `GET` retrieve information about current contact
        - [x] `GET` retrieve information about specific member or record
        - [ ] `PUT` update information about exising member or contact
        - [ ] `DELETE` Delete contact
        - [ ] `POST` Accept terms of use
    - CustomFields
        - [x] `GET` List of custom fields related to contact and members
        - [ ] `POST` Create a new contact / membership field
    - SavedSearch
        - [x] `GET` List of saved searches
        - [x] `GET` Saved search and found contacts


- [ ] Pictures
    - [ ] `GET` Download picture
    - [ ] `POST` Upload picture


- [ ] Attachments
    - [ ] `GET` Download attachment
    - [ ] `GET` Attachment infos
    - [ ] `POST` Upload attachments

- [ ] Membership
    - Levels
        - [x] `GET` List of all memberships
        - [x] `GET` Retrieve information about specific membership level
    - Bundles
        - [x] `GET` List of membership bundles
        - [x] `GET` Membership bundle details
    - Groups
        - [x] `GET` List of Ad hoc member groups
        - [x] `GET` Ad hoc member group
    - Operations
        - [ ] `POST` Approve pending memberships
        - [ ] `POST` Reject pending memberships
        - [ ] `POST` Generate or update invoice for pending memberships


- [ ] Events
  - Base
    - [ ] `GET` Events list
    - [ ] `POST` Create a new Event record
    - [ ] `GET` Retrieve information about specific event
    - [ ] `PUT` Update information about specific event
    - [ ] `DELETE` Delete event
    - [ ] `POST` Clone existed event
  - EventRegistrationTypes
    - [ ] `GET` Event registration types list
    - [ ] `POST` Create a new event registration type
    - [ ] `GET` Event registration type details
    - [ ] `PUT` Update information about the existing event registration type
    - [ ] `DELETE` Delete event registration type
  - EventRegistrations
    - [ ] `GET` Event registrations list
    - [ ] `POST` Create a new event registration
    - [ ] `GET` Event registrations details
    - [ ] `DELETE` Event registrations