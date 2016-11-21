package lambda.chaining_operations;

/**
 * Author: ddubson
 */
@FunctionalInterface
public interface Operation {
    void operate(String s);
}
