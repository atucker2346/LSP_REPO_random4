# Comparison of Assignment 2 and Assignment 3 Implementations

The transition from Assignment 2 to Assignment 3 represents a shift from a procedural programming model to an object-oriented design. While both implementations perform the same ETL (Extract, Transform, Load) process and produce identical outputs, their internal structures differ significantly. Assignment 2 follows a linear, procedural approach using static methods and primitive data types, whereas Assignment 3 refactors the solution into multiple classes that follow core object-oriented principles such as encapsulation, abstraction, and separation of concerns.

## Design Differences

### Assignment 2: Procedural Design

Assignment 2 uses a procedural approach in which all logic is contained within static methods inside a single `ETLPipeline` class. The `main` method orchestrates the entire ETL process sequentially. Each step—extracting data from the input file, transforming it, and loading it into the output file—is executed directly in order without abstraction or modular separation.

Data is handled using primitive types such as `int`, `String`, and `BigDecimal`, with values stored in local variables and passed between methods. There are no objects representing domain entities; instead, related pieces of data (such as product ID, name, price, and category) are managed independently. The overall structure follows a top-down, linear flow in which all responsibilities are centralized in one class. While this approach is straightforward and easy to implement for small programs, it becomes harder to maintain and extend as complexity grows.

### Assignment 3: Object-Oriented Design

Assignment 3 refactors the procedural solution into a more modular and object-oriented design. Responsibilities are divided among three distinct classes:

- **Product class**: Encapsulates product data (ProductID, Name, Price, Category) as an object.
- **ProductTransformer class**: Contains transformation logic implemented as instance methods.
- **ETLPipeline class**: Coordinates the ETL process using objects rather than primitive data types.

Instead of passing multiple individual variables throughout the program, Assignment 3 creates `Product` objects to represent each row of data. This improves readability and organization by grouping related data together. The design also follows the Single Responsibility Principle, as each class has one clearly defined purpose. The `Product` class manages data representation, the `ProductTransformer` class handles business logic, and the `ETLPipeline` class manages file input/output and overall orchestration.

## How Assignment 3 is More Object-Oriented

Assignment 3 demonstrates several key object-oriented principles that were not present in Assignment 2.

### Encapsulation

In Assignment 3, product data is encapsulated within the `Product` class. The fields are declared `private` (e.g., `private int productId`, `private String name`), and access is provided through public getter and setter methods. This prevents direct modification of the internal state from outside the class and ensures controlled access to data. Encapsulation improves reliability and reduces the risk of unintended side effects.

### Abstraction

The transformation logic is abstracted into the `ProductTransformer` class. The `ETLPipeline` class does not need to know how transformations are implemented; it simply interacts with high-level `Product` objects. This separation hides implementation details and allows transformation logic to be modified without affecting other parts of the system.

### Separation of Concerns

Assignment 3 eliminates the monolithic structure of Assignment 2 by clearly dividing responsibilities:

- `Product` handles data representation.
- `ProductTransformer` handles business rules and transformations.
- `ETLPipeline` handles file operations and process coordination.

This modular design improves maintainability and makes future enhancements easier to implement.

## Object-Oriented Concepts Used

Assignment 3 incorporates several core object-oriented concepts:

- **Objects**: The program creates `Product` objects to represent each row of input data. Instead of passing separate variables (id, name, price, category), the program manipulates cohesive objects that bundle related attributes together.

- **Classes**: Three primary classes structure the system: `Product`, `ProductTransformer`, and `ETLPipeline`. Each class defines behavior and state relevant to its role.

- **Encapsulation**: Private fields in the `Product` class protect internal data, ensuring that changes occur only through defined methods.

- **Inheritance (Potential Use)**: Although not required for this assignment, inheritance could be introduced if different product categories required specialized behavior. For example, an `ElectronicsProduct` class could extend `Product` and override certain transformation rules.

- **Polymorphism (Potential Use)**: Polymorphism could be applied through method overloading or by implementing interfaces for multiple transformation strategies. For example, different transformation strategies could implement a common interface and be used interchangeably.

## Testing to Confirm Equivalent Functionality

Although Assignment 3 restructures the code internally, it must produce the same external behavior as Assignment 2. Several testing methods can confirm this equivalence.

**First**, both implementations should be run using the same input file (e.g., `data/products.csv`) containing a variety of valid rows, invalid rows, edge cases, and inconsistent formatting.

**Second**, the generated output files (e.g., `data/transformed_products_assignment2.csv` and `data/transformed_products_assignment3.csv`) should be compared line-by-line or byte-by-byte using a tool such as `diff` to ensure they are identical.

**Lastly**, console output summaries—including counts of rows read, transformed, and skipped—should match exactly between implementations.


## Conclusion

The primary difference between Assignment 2 and Assignment 3 lies in design philosophy rather than functionality. Assignment 2 uses a procedural, linear approach with centralized logic and primitive data handling. Assignment 3 refactors the same functionality into an object-oriented architecture that emphasizes encapsulation, abstraction, and separation of concerns. Although both implementations produce identical results, Assignment 3 offers improved maintainability, readability, and scalability. This demonstrates that object-oriented design enhances code organization and long-term flexibility without changing the external behavior of the program.
