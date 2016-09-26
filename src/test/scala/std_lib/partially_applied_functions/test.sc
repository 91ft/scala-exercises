def sum(a: Int, b: Int) = a + b
def curriedSum(a: Int) = (b : Int) => a + b
def addOne = (sum _).curried
def addTwo = sum(2, _ : Int)