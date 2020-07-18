# UIL Topics

* [UIL Topics](#uil-topics)
  * [Base Conversions](#base-conversions)
    * [Binary](#binary)
    * [Octal](#octal)
    * [Hexadecimal and Binary](#hexadecimal-and-binary)
  * [User-defined classes](#user-defined-classes)
    * [Access specifiers](#access-specifiers)
    * [Keywords `final` and `static`](#keywords-final-and-static)

## Base Conversions

A number $N$ in base/radix $b$:
$(N)_b=d_{n-1}d_{n-2}----d_1d_0.d_{-1}d_{-2}----d_{-m}$

MSB = $d_{-m}$
LSB = $d_{n-1}$

### Binary

Decimal to binary example: $(10.25)_{10}=(x.y)_2$

Integer component:
 $10\%2=0$
 $5\%2=1$
 $2\%2=0$
 $1\%2=1$
 LSB is 0 and MSB is 1: $x=1010$.

Fractional component: Multiply the values by 2 until they are whole numbers, use each whole number component as the binary digit.
$0.25\times{2}=0.50=\underline0+0.50$
$0.50\times{2}=1.00=\underline1+0.00$
$y=0.\underline{01}$

Binary to decimal: $(1010.01)_2=(a.b)_{10}$

Integer component: $a=1\times2^3+0\times2^2+1\times2^1+0\times2^0=10$
Decimal component: $b=0\times2^{-1}+1\times2^{-2}=0.25$

### Octal

$(10.25)_{10}$
$(10)_{10}=(12)_8$

Fractional:
$0.25\times8=2.00$
$(0.25)_10=(0.2)_8$

$(10.25)_{10}=(12.2)_8$

### Hexadecimal and Binary

![hex-bin table](https://media.geeksforgeeks.org/wp-content/uploads/3-29.jpg)

$(3A)_{16}=(00111010)_2$

To convert from binary to hex, group in 4s from right to left, add 0s for uneven endings as padding.

$1111011011$
$(001111011011)_2 = (3DB)_{16}$

## User-defined classes

Constructors, overloading, overriding.

```java
class Test {
    int a;
    int b;
    //default
    Test() {
        a = 0;
        b = 0;
    }
    //init
    Test(int aa, int bb) {
        a = aa;
        b = bb;
    }
    //overloaded init
    Test(int number) {
        a = number;
        b = number;
    }
    //method to be overridden in child class
    void print() {
        System.out.println("Parent class");
    }
    //methods, etc.
}
class Child {
    void print() {
        System.out.println("Child class");
    }
}
public static void main(String[] args) {
    Test one = new Test();
    Test two = new Child();
    one.print();
    two.print();
}
/*
output:
Parent class
Child class
*/
```

### Access specifiers

* **Private** - methods/data members only accessible within declared class, any other class or same package--no access (only apply to nested classes because **only visible within enclosing class**)
* **Public** - Widest scope; classes, methods, data members accessible from everywhere in program (no restriction)
* **Protected** - Methods/data members accessible within same package or sub classes in different package
* **Default** (no specification) - data members, class, methods only accessible within same package

### Keywords `final` and `static`

* Final classes can't be extended
* Final methods can't be overridden
* Properties (*fields*) of a final reference variable can be changed
* Final fields have to be initialized before completion of the constructor 
* Final method arguments can't be changed inside the method body 

Static keywords - member belongs to type not instance of the type--only one instance created and shared among members of class.
* Static field - one copy initialized/declared for all instances of class
* Static methods - belong to class, not object
bruh
