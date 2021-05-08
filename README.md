# Java Exception

예외는 어플리케이션 런타임에 원하지 않거나 예상하지 못한 채 발생하는 이벤트로, 어플리케이션의 정상적인 흐름을 방해한다.  

## Error vs Exception

#### Error

error 는 어플리케이션에서 처리할 수 없는 심각한 문제를 나타낸다.  
즉, 어떤 처리 방법으로도 복구할 수 없는 상태이다.  

어플리케이션의 비정상적 종료의 원인이 되며, unchecked 유형이고 대부분 런타임에 발생한다.

#### Exception

exception 은 어플리케이션 런타임에 발생하는 어떤 상태를 의미하며 어플리케이션이 종료될 수 있다.  
다만, try, catch 및 throw 키워드를 사용하여 복구할 수 있다는 것이 error 와의 큰 차이점이다.  

|Errors|Exceptions|
|------|----------|
|복구가 불가능하다.|try-catch 블럭을 사용하거나 호출자에게 exception 을 던져 복구할 수 있다.|
|모든 error 는 unchecked 유형이다.|checked 유형과 unchecked 유형이 있다.|
|대부분의 error 는 런타임 중 환경적인 요인으로 발생한다.|어플리케이션 자체에서 exception 이 발생한다.|
|컴파일 단계에서 알 수 없다.|checked 유형인 경우 컴파일 단계에서 알 수 있다.|
|`java.lang.Error` 패키지에 정의되어 있다.|`java.lang.Exception` 패키지에 정의되어 있다.|

#### 공통점

error 와 exception 은 모두 `java.lang.Throwable` 클래스의 하위 클래스이다.

<hr>

#### References

> 웹 문서
> - [geeksforgeeks | Exceptions in Java](https://www.geeksforgeeks.org/exceptions-in-java)
> - [geeksforgeeks | Checked vs Unchecked Exceptions in Java](https://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java)
> - [geeksforgeeks | Java Program to Handle Unchecked Exception](https://www.geeksforgeeks.org/java-program-to-handle-unchecked-exception)
> - [geeksforgeeks | Java Program to Handle Runtime Exceptions](https://www.geeksforgeeks.org/java-program-to-handle-runtime-exceptions)
> - [geeksforgeeks | Errors V/s Exceptions In Java](https://www.geeksforgeeks.org/errors-v-s-exceptions-in-java/)
> - [geeksforgeeks | Flow control in try catch finally in Java](https://www.geeksforgeeks.org/flow-control-in-try-catch-finally-in-java/)
> - [geeksforgeeks | Using throw, catch and instanceof to handle Exceptions in Java](https://www.geeksforgeeks.org/using-throw-catch-and-instanceof-to-handle-exceptions-in-java)
> - [geeksforgeeks | Built-in Exceptions in Java with examples](https://www.geeksforgeeks.org/built-exceptions-java-examples/)
