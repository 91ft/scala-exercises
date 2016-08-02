# Scala Exercises 
https://www.scala-exercises.org

# Scala Exercises Cat

### Semigroup
Semigroup은 결합법칙이 가능한 combine이란 함수를 가지고 있는 모든 타입이다.
```
// 결합법칙
((a combine b) combine c) == (a combine (b combine c))
```
### Monoid
Semigroup을 상속받은 것으로 combine과 교환법칙이 가능한 empty를 제공하는 모든 타입이다.
```
// 교환법칙
(combine(x, empty) == combine(empty, x) == x)
```

### Functor
map이란 함수를 가지고 있는 모든 타입이다.
```
def map[A, B](fa: F[A])(f: A => B): F[B]
```