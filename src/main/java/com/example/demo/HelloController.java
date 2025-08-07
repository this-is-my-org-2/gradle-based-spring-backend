package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    // Violation: Mutable static field, which is not thread-safe.
    private static List<String> processedItems = new ArrayList<>();

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello, %s!", name);
    }

    // This method intentionally violates linting rules for testing purposes.
    public String _bad_method_for_lint(String unusedParam) {
        System.out.println("This is a bad practice for logging!");
        String magicString = "Magic Number is ";
        return magicString + 123; // Violation: Magic number
    }

    /**
     * This method is intentionally complex and full of bad practices to test
     * advanced static analysis rules like cyclomatic complexity, exception handling, etc.
     * It has no Javadoc for its parameters or return value.
     */
    public List<String> processDataUnsafely(String data, int type) {
        // Violation: High cyclomatic complexity and deep nesting.
        if (data != null && !data.isEmpty()) {
            String log = "";
            for (int i = 0; i < type; i++) {
                if (type > 5) { // Violation: Magic number
                    if (i % 2 == 0) {
                        log += "Processing even step: " + i + "\n"; // Violation: Inefficient string concatenation in a loop.
                        processedItems.add(data); // Violation: Modifying static state.
                    }
                } else {
                    log += "Processing step: " + i + "\n";
                }
            }
            System.out.println(log);
        }

        try {
            if (type == 99) { // Violation: Magic number
                throw new IllegalArgumentException("Invalid type");
            }
        } catch (Exception e) { // Violation: Catching generic Exception.
            // Violation: Empty catch block, swallowing the exception.
        }

        // Violation: Returning null instead of an empty collection.
        return null;
    }
}
