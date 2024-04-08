@E2E
Feature: Create Repair Job in Phoenix App

  Background: Generate Login Token
    Given User Logged in with userName "iamfd" and password "password"
    Then User generate Login Token
    Then User get master Data
@e2e
  Scenario: Create In-Warranty WorkFlow
    Given User fills device details as below
      | Device Details        | Value       | Mandatory Field ? |
      | Manufacturer Name     | apple       | true              |
      | Product Name          | ORANGE-Gold | true              |
      | Model Name            | IPhone 11   | true              |
      | IMEI 1                | 1121221     | true              |
      | IMEI 2                | 44654646    | true              |
      | Date Of Purchase      | 26-12-2023  | true              |
      | Platform Issue Raised | frontDesk   | default           |
    And User fills problem details as below
#    Max Three Problems can be Added
      | Problem       | Remark             | Mandatory Field ? |
      | Battery Issue | Over Heating Issue | true              |

    And User fills customer details as below
#    To insert blank value user [blank]
      | User Details         | Value   | Mandatory Field ? |
      | First Name           | 1       | true              |
      | Last Name            | 1       | true              |
      | Contact No           | 1       | true              |
      | Alternate Contact No | 1       | false             |
      | Email ID             | 1       | true              |
      | Alternate Email ID   | 1       | false             |
      | Flat/Society No      | 1       | true              |
      | Apartment Name       | 1       | true              |
      | Landmark             | 1       | true              |
      | Street Name          | 1       | true              |
      | Area                 | 1       | true              |
      | Country              | 1       | true              |
      | State                | 1       | true              |
      | Pin code             | 1       | true              |
      | Service Location     | [blank] | default           |