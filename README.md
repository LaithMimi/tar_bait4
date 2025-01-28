
# tar_bait4_JUnit tests

## Overview
`tar_bait4` is a Java-based project that includes implementations for managing a supermarket catalog and account, as well as operations on groups of integers. The project is divided into two main parts, each located in different packages.

## Project Structure
- `src/tar_bait4_q1`: Contains the implementation for a supermarket system.
  - `Account.java`: Manages products in a user's account, including adding, removing, and calculating total amounts.
  - `Catalog.java`: Manages the catalog of products with their prices.
  - `SupermarketTest.java`: JUnit tests for the supermarket system.

- `src/tar_bait4_q2`: Contains the implementation for group operations.
  - `Group.java`: Manages a group of integers, including methods for adding, removing, searching, and performing union and intersection operations.
  - `Main.java`: Demonstrates the usage of `Group` class methods.

## Installation
1. Clone the repository:
   ```
   git clone https://github.com/LaithMimi/tar_bait4.git
   ```
2. Navigate to the project directory:
   ```
   cd tar_bait4
   ```
3. Compile the project using a Java compiler:
   ```
   javac src/tar_bait4_q1/*.java src/tar_bait4_q2/*.java
   ```

## Usage
1. Run the supermarket system tests:
   ```
   java -cp .:path/to/junit-platform-console-standalone-1.8.1.jar org.junit.platform.console.ConsoleLauncher --select-class tar_bait4_q1.SupermarketTest
   ```

2. Run the group operations demonstration:
   ```
   java src/tar_bait4_q2/Main
   ```

## Features
### Supermarket System
- Add, remove, and change quantities of products in an account.
- Calculate the total amount of products in an account, including applying discounts.
- Manage a catalog of products with prices.
- JUnit tests to verify the functionality of the supermarket system.

### Group Operations
- Add and remove elements in a group.
- Search for elements in a group.
- Perform union and intersection operations on two groups.
- Iterator to traverse through group elements.
- Demonstrates the usage of group operations in the `Main` class.

## Contributing
Contributions are welcome! Please create a pull request with your changes.

## License
This project is licensed under the MIT License.
