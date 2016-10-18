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
```
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

## Map
스칼라의 Map
```scala
val map = Map("a" -> 1, "b" -> 2, "c" -> 2, "c" -> 3)
map.size // 3
map.keys // Set("a", "b", "c")
map.values // MapLike(1, 2, 3)
map("a")
map.get("a")
map.getOrElse("a")
```
값 추가, 삭제
```scala
val map = Map("a" -> 1, "b" -> 2, "c" -> 3)
map + ("d" -> 4, "e" -> 5)
map - ("b", "c")
```
키와 값이 여러 타입을 가질수 있다.
```scala
val map = Map("a" -> 1, 2 -> "b", true -> 3)
map("a")
```
값은 tuple2이며, ->는 값을 받아서 tuple2로 반환하는 함수다

## Set
스칼라의 Set
```scala
val set = Set("a", 1, true, "a")
set.size should be(3)
set.contains("a")
set("a")
```
값 추가, 삭제
```scala
val set = Set(1,2,3)
set + (3,4,5)
set - (2,3,4)
```
intersect, union, subsetOf, diff
```scala
val set1 = Set(1,2,3)
val set2 = Set(2,3,4,5)

set1 intersect set2 // Set(2, 3)
set1 union set2 // Set(5, 1, 2, 3, 4)
set1 subsetOf set2 // false
(set1 - 1) subsetOf set2 // true
set2 diff set1 // Set(4, 5)
```

## Pattern Matching
스칼라에는 자바의 switch 문과 비슷하지만, 더 강력한 match - case 가 있다.

* 자바의 switch - case
```
String result = null;
switch (num) {
    case 1 : result = "one"; break;
    case 2 : result = "two"; break;
    default : result = "other";
}
```
* 스칼라의 match
```
val result = num match {
    case 1 => "one"
    case 2 => "two"
    case _ => "other" // 이게 없다면 MatchError 발생
```
* 특징
fall-through 문제가 사라짐
```
String result = null;
switch (num) {
    case 1 : result = "one"; break;
    case 2 : result = "two";
    default : result = "other";
}
// num = 2 인 경우 결과값은?
```
_는 default를 대체하는 것이 아니다.
```
val result = num match {
    case 1 => "one"
    case 2 => "two"
    case a : Int  => "other" // case _ : Int => "other" // case _ => "other"
}
```
: 가 => 로 변경됨
- :, ->, =>, <- 다 헛갈리지만... 잘 생각해보면 함수 선언모양과 비슷하다.
- case 한줄 한줄이 다 함수이다.
```
val result = num match {
    case n : String => "string"
    ...
}
// 함수선언 : (name : String) => s"${name}님"
```
* 특징
1. 맞는 case가 없는 경우 에러가 발생한다.
1. break가 없어도 다음 case로 넘어가지 않는다.
1. _는 default 값을 의미하는 것이 아니다. 
1. case 한줄 한줄이 다 함수이다.
1. match는 표현식이다.
```
case 문은 함수다.
- def func(Int) = { ... } (x)
- def func(n : Int) = { ... } (o)
```

# case class
case 수식자가 붙은 클래스. 몇 가지 편리한 기능이 자동으로 제공된다.
```scala
case class User(id : Int, name : String)
```
1. 같은 이름의 팩토리 메소드가 있다.
```
val user = User(1, "박보검")
```
2. 클래스 파라미터에 암시적으로 val 접두어를 붙인다.
```
user.name // 박보검
```
3. toString, hashCode, equals의 자연스러운 구현을 추가한다
```
val user1 = User(1, "박보검")
val user2 = User(1, "박보검")

user1 == user2
```
4. copy 메소드를 추가한다.
```
val user = User(1, "박보검", "M", "010-1234-5678")
val copiedUser = user.copy(tel = "010-1234-5679")
```
5. 패턴 매치를 지원한다.

# Partially Applied Function
함수의 인자중 일부를 적용한 새로운 함수를 생성할 수 있다.
```scala
def sum(a: Int, b: Int) = a + b 
def addTwo = sum(2, _ : Int)
```

```
def sum1(a: Int, b: Int) = a + b
def sum2(a: Int)(b: Int) = a + b
def sum3(a: Int) = (b : Int) => a + b

// sum1(1) == sum2(1) == sum3(1)
```

# Partial Function
Partial Function : 부분함수

Partially Applied Function : 파라미터 중 부분만 적용된 새로운 함수

Partial Function ≠ Partially Applied Function

* 부분함수란?
* 일부 입력에 대해서는 정의되지 않는 함수
* = 일부 입력에 대해 동작하지 않는 함수. 일부 입력에 대해 끝나지 않는 함수.
* 부분함수의 예
```scala
def max(list : List[Int]) = {
  if (list.isEmpty) throw ArithmeticException
  list.max
}
```
* 예상치 않는 시점에 오류가 발생할 수 있으므로 가능한 완전함수로 만들어서 사용하는 것이 좋다
```scala
def max(list : List[Int]) : Option[Int] = {
  if (list.isEmpty) None
  Some(list.max)
}
```
* 어쩔 수 없이 부분함수를 사용해야 할 때 : 정해진 프레임워크를 사용한다
```scala
val func1 = new PartialFunction[List[Int], Int] {
  def isDefinedAt(list: List[Int]) = list.nonEmpty
  def apply(list: List[Int]) = list.sum / list.length
}
```
* 축약하면
```scala
val func2: PartialFunction[List[Int], Int] = { 
  case list if list.nonEmpty => list.sum / list.length 
}
```

# for
Java vs Scala
```
// 1,2,3 => 1,4,9

List<Integer> list = new LinkedList<Integer>();
list.add(1);
list.add(2);
list.add(3);

List<Integer> doubled = new LinkedList<Integer>();
for (Integer num : list) {
    doubled.add(num * num);
}
```
Scala map
```
// map
val list = List(1,2,3)
val doubled = list.map(num => num * num)
```
Scala for
```
// for
val list = List(1,2,3)

for {
    num <- list
} yield num * num
```

#### Java : List, Option, Future
* List
```
for (Integer num : list) {
  // 여기서 뭔가 처리
}
```
* Option => 값이 없을 수 있다
```
if (num != null) {
  // 여기서 뭔가 처리
}
```
* Future
```
FutureTask<String> future =
new FutureTask<String>(new Callable<String>() {
    public String call() {
        return searcher.search(target);
    }}
);
executor.execute(future);
```

#### Scala (Scala지만 Java처럼 짠다면...): List, Option, Future
* List
```
val first = list(0)
val second = list(1)
```
* Option => 값이 없을 수 있다
```
val someValue = optionValue.getOption()
if (someValue != None) {
    /* 여기서 뭔가 처리 */
}

optionValue.getOption() match {
    case Some => /* 여기서 뭔가 처리 */
    case None => /* 여기서 뭔가 처리 */
}
```
* Future
```
val result = await { futureValue }
/* 여기서 뭔가 처리 */
```

#### Scala : List, Option, Future
* List
```
list.map(num => /* 여기서 뭔가 처리 */)
```
* Option => 값이 없을 수 있다
```
optionValue.map(num => /* 여기서 뭔가 처리 */)
```
* Future
```
futureValue.map(num => /* 여기서 뭔가 처리 */)
```

#### Java
Future로 넘어오는 값이 null일 수도 있는 List값인 경우 처리
```
FutureTask<String> future =
new FutureTask<List>(new Callable<List>() {
    public String call() {
        if (result != null) {
            for (String item : list) {
                // 여기서 뭔가 처리
            }
        }
        return ...
    }}
);
executor.execute(future);

```

#### Scala
```
val something : Future[Option[List[String]]] = ...

something.map(optionResult => 
    optionResult.map(listResult => 
        listResult.map(item => /* 여기서 뭔가 처리 */)))
```
for
```
val ressult = for {
    optionResult <- something
    listResult <- optionResult
    item <- listResult
} yield /* 여기서 뭔가 처리 */
```