# Java Exception

예외는 애플리케이션 런타임에 원하지 않거나 예상하지 못한 채 발생하는 이벤트로, 애플리케이션의 정상적인 흐름을 방해한다.  

## Error vs Exception

#### Error

오류는 애플리케이션에서 처리할 수 없는 심각한 문제를 나타낸다.  
즉, 어떤 처리 방법으로도 복구할 수 없는 상태이다.  

애플리케이션의 비정상적 종료의 원인이 되며, unchecked 유형이고 대부분 런타임에 발생한다.

#### Exception

예외는 애플리케이션 런타임에 발생하는 어떤 상태를 의미하며 애플리케이션이 종료될 수 있다.  
다만, try, catch 및 throw 키워드를 사용하여 복구할 수 있다는 것이 오류와의 큰 차이점이다.  

|Errors|Exceptions|
|------|----------|
|복구가 불가능하다.|try-catch 블럭을 사용하거나 호출자에게 예외를 던져 복구할 수 있다.|
|모든 오류는 unchecked 유형이다.|checked 유형과 unchecked 유형이 있다.|
|대부분의 오류는 런타임 중 환경적인 요인으로 발생한다.|애플리케이션 자체에서 예외가 발생한다.|
|컴파일 단계에서 알 수 없다.|checked 유형인 경우 컴파일 단계에서 알 수 있다.|
|`java.lang.Error` 패키지에 정의되어 있다.|`java.lang.Exception` 패키지에 정의되어 있다.|

#### 공통점

오류와 예외는 모두 `java.lang.Throwable` 클래스의 하위 클래스이다.

## Hierarchy

![exception hierarchy](images/IMG_exception_hierarchy.png)

## Checked vs Unchecked

#### Checked

컴파일 단계에서 확인이 되어 미리 알 수 있는 예외이다.  
메서드 내의 일부 코드에서 확인된 예외가 발생하면 메서드는 try-catch 문을 사용하여 예외를 처리하거나 throws 키워드를 사용하여 예외를 지정해야한다.  

![exception checked](images/IMG_exception_checked.png)

예를 들어, 위와 같이 FileReader() 를 사용할때는 컴파일 단계에서 어떤 예외가 발생할 수 있는지 확인이 가능하다.    
따라서 FileReader() 를 사용하려면 FileNotFoundException 이라는 예외를 try-catch 문을 사용해 처리하거나 throws 키워드를 사용해 지정해줘야 한다. 

```java
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader file = new FileReader("/test/study.txt");
    }
}
```

#### Unchecked

컴파일 단계에서 확인이 되지 않아 런타임에서만 알 수 있는 예외이다.  

```java
public class Main {
    public static void main(String[] args) {
        int x = 0;
        int y = 10;
        int z = y / x;
    }
}
```

위와 같은 애플리케이션이 존재한다고 할 때, 컴파일은 이상없지 되지만 실행하면 `java.lang.ArithmeticException` 이 발생한다.

![exception checked](images/IMG_exception_unchecked.png)

컴파일러는 `java.lang.ArithmeticException` 이 unchecked 예외이기 때문에 컴파일을 허용한다.

## Handle an exception

Java 예외 처리는 try, catch, finally, throw, throws 다섯 가지 키워드를 통해 관리된다.  

#### try-catch-finally

```java
try {
    // block of code to monitor for errors
    // the code you think can raise an exception
}
catch (ExceptionType1 exOb) {
    // exception handler for ExceptionType1
}
catch (ExceptionType2 exOb) {
    // exception handler for ExceptionType2
}
finally {   // optional
    // block of code to be executed after try block ends
}
```

#### try-with-resources

```java
try (declare resources here) {
    // use resources
}
catch (FileNotFoundException e) {
    // exception handling
}
```

try-with-resources 문은 하나 이상의 리소스를 선언하는 try 문 이다.  
리소스는 애플리케이션이 사용을 마치면 닫아줘야하는 객체이다.

try-with-resources 문은 실행이 끝날 때 각 리소스를 닫도록 한다.  
리소스를 닫지 않으면 누수가 발생할 수 있으며 장애의 원인이 되기도 한다.  

#### Replacing try–catch-finally With try-with-resources

try–catch-finally
```java
Scanner scanner = null;
try {
    scanner = new Scanner(new File("test.txt"));
    while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
} finally {
    if (scanner != null) {
        scanner.close();
    }
}
```
try-with-resources
```java
try (Scanner scanner = new Scanner(new File("test.txt"))) {
    while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
    }
} catch (FileNotFoundException fnfe) {
    fnfe.printStackTrace();
}
```

#### try-with-resources With Multiple Resources

```java
try (
    Scanner scanner = new Scanner(new File("testRead.txt"));
    PrintWriter writer = new PrintWriter(new File("testWrite.txt"))
) {
    while (scanner.hasNext()) {
        writer.print(scanner.nextLine());
    }
}
```

#### throw

throw 키워드는 메서드 또는 코드 블럭에서 명시적으로 예외를 throw 하는데 사용된다.  

```java
throw <exception_instance>

// example
throw new ArithmeticException("/by zero");
```

이때 exception instance 는 Throwable 타입이거나 Throwable 의 하위 클래스여야만 한다.  

애플리케이션 실행 과정 중 throw 문이 실행되면 즉시 해당 블럭은 중지되고 메서드 call stack 에 따라 try 문과 예외에 일치하는 catch 문이 있는지 확인한다.  
일치하는 try-catch 문이 있다면 그에 맞는 처리를 진행하고, 없다면 기본 예외 처리기가 애플리케이션을 중지한다.  

```java
public class Main {
    public static void main(String[] args) {
        try {
            throwNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException catch");
        }
    }

    private static void throwNullPointerException() {
        throw new NullPointerException();
    }
}
```

#### throws

throws 는 해당 메서드가 명시된 예외를 throw 할 수 있음을 나타내기 위해 사용되는 키워드이다.  

```java
public example() throws <exception_list>
```

해당 키워드를 사용하면 예외가 발생하는 코드 블럭 안에서 처리를 하는것이 아니라 해당 메서드를 호출한 블럭으로 예외를 던지게 된다.  
그래서, 예외에 대한 처리를 호출한 곳에서 하도록 할 때 사용한다.

## Custom Exception

때때로 예외를 직접 정의해야할 때도 있다.  
비즈니스 로직 및 work flow 와 관련된 예외이다. 이런 예외는 애플리케이션 사용자 또는 개발자가 정확한 문제가 무엇인지 이해하는데 도움이 된다.

#### Custom Checked Exception

custom checked exception 을 생성하려면 java.lang.Exception 클래스를 상속해야한다.

```java
public class IncorrectFileNameCheckedException extends Exception {
    
    public IncorrectFileNameCheckedException(String errorMessage) {
        super(errorMessage);
    }
    
    public IncorrectFileNameCheckedException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
```

#### Custom Unchecked Exception

custom unchecked exception 을 생성하려면 java.lang.RuntimeException 클래스를 상속해야한다.  

```java
public class IncorrectFileExtensionUncheckedException extends RuntimeException {
    
    public IncorrectFileExtensionUncheckedException(String errorMessage) {
        super(errorMessage);
    }

    public IncorrectFileExtensionUncheckedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}

```

<hr>

#### References

> 웹 문서
> - [geeksforgeeks | Exceptions in Java](https://www.geeksforgeeks.org/exceptions-in-java)
> - [geeksforgeeks | Checked vs Unchecked Exceptions in Java](https://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java)
> - [geeksforgeeks | Errors V/s Exceptions In Java](https://www.geeksforgeeks.org/errors-v-s-exceptions-in-java/)
> - [geeksforgeeks | Flow control in try catch finally in Java](https://www.geeksforgeeks.org/flow-control-in-try-catch-finally-in-java/)
> - [geeksforgeeks | throw and throws in Java](https://www.geeksforgeeks.org/throw-throws-java/)
> - [geeksforgeeks | Try-with-resources Feature in Java](https://www.geeksforgeeks.org/try-with-resources-feature-in-java/)
> - [geeksforgeeks | Built-in Exceptions in Java with examples](https://www.geeksforgeeks.org/built-exceptions-java-examples/)
> - [baeldung | Java – Try with Resources](https://www.baeldung.com/java-try-with-resources)
> - [baeldung | Create a Custom Exception in Java](https://www.baeldung.com/java-new-custom-exception)
