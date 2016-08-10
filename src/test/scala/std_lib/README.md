## Tuple
각기 다른 타입들을 가지고 있는 컨테이너 객체. (List[String]은 문자열만 가질수 있다.)
```scala
val t = (1, "hello", Console)
t._2 // hello
```

> t.get(0) 이렇게 사용하지 않는 이유

> Tuple의 개수가 제한되어 있는 이유

```scala
val t1 = (1, "hello", Console)
val t2 = new Tuple3(1, "hello", Console)
```
t.get(0) 이렇게 사용하지 않는 이유
- 배열처럼 보이기 때문에 그렇게 착각하는 것. x번째 변수인 t._x에 접근한다는 표현이 맞음.

Tuple의 개수가 제한되어 있는 이유
- 클래스를 무한정 만들수 없어서

## Higher Order Functions
1급 계층 함수
- 함수를 인자로 넘기거나 반환할 수 있다.
- 함수를 _실행시점에 새로 만들어서_ 인자로 넘기거나 반환할 수 있다. (c언어 포인터, 자바 클래스는 새롭게 만들지 못하므로 2급 계층)
def와 val, 둘의 차이는?
```scala
def defFunc = (x: Int) => x + 1
val valFunc = (x: Int) => x + 1
```
함수 리터럴과 함수 값
```
함수 리터럴 : 함수 값 ≒ 클래스 : 객체
```
def defFunc는 함수 리터럴이다.
val valFunc는 함수 값이다. (함수 값 ≒ 객체)
```scala
def defNoting: Int => Boolean = ???
val valNoting : Int => Boolean = ???
```
클로저
- 함수 리터럴로 실행시점에 만들어낸 함수 값(객체)
```scala
var num = 1

def func = (x: Int) => x + num // x + 1

val result1 = func(10)

incrementer = 2
val result2 = func(10)
```
- num을 자유변수(free variable)라고 부른다.
- 클로저란 자유변수들을 capture해서 closing한다는 의미에서 따온말.

## List
스칼라의 List는 기본적으로 immutable. (변경할 수 없다)
```scala
val list1 = List.apply(1,2,3)
val list2 = List(1,2,3)
```
접근하기
```scala
val list = List(1,2,3)
list.headOption

// head, tail
val matched = list match {
  case head :: tail => Some(head)
  case Nil => None
}
```
변형, 필터링하기
```scala
val list = List(1,2,3)
val mapped = list.map(i => i.toString)
val filtered = list.filter(i => i % 2 == 0)
```
reduce, fold
```scala
val list = List(1,2,3)
val reduce = list.reduce((a, b) => a + b)
val fold = list.fold(10)((a, b) => a + b)
```