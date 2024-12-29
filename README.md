# Employee Serialization System

This Java-based application demonstrates how to manage employee data by reading from a text file, serializing the data into a binary file, and then deserializing it back into employee objects. The system performs operations like storing and retrieving employee information in a serialized format.

## Features
- **Read Employee Data**: The program reads employee data from a text file (`employees.txt`) containing employee details such as ID, name, and salary.
- **Serialize Employee Data**: After reading the data, it serializes the list of employee objects into a binary file (`employees.dat`).
- **Deserialize Employee Data**: The serialized data is read back from the binary file and deserialized into employee objects, which are then printed to the console.

## Technologies Used
- **Java**: Core language for the implementation.
- **Serialization**: Java's `Serializable` interface is used to serialize and deserialize employee objects.
- **File Handling**: Java’s I/O classes (`BufferedReader`, `FileReader`, `ObjectOutputStream`, `ObjectInputStream`) are used to handle file operations.

## Setup Instructions
1. Clone this repository to your local machine.
   ```bash
    https://github.com/Rubanvijay/EmployeeSerializationSystem.git
