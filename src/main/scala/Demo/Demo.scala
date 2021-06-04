package Demo

object Demo {

  def main(args: Array[String]): Unit = {

    val name = "Mitul";
    val age = 21;

    // different method used for print string
    //    println("---different method used for print string---")
    //    println("Hello World");
    //    println(name + " is " + age + " years old");
    //    println(s"$name is $age years old");
    //    println(f"$name%s is $age%d years old");
    //    println(s"Hello \nWorld");
    //    println(raw"Hello \nWorld");
    //    println();

  }

  // functional programming
  println("---functional programming---")
  var g = 10;

  def rt(i: Int): Int = {
    g = i + g;
    return g;
  }

  var v1 = rt(5);
  println(v1);
  println();


  println("---anonymous function---")
  var d = (i: Int) => {
    i * 2
  }: Int; // anonymous function
  println(d(3));
  println();


  // recursion tail with
  println("---recursion tail with---")

  def rFacorial(n: Int, f: Int): Int = {
    if (n <= 0)
      return f;
    else
      return rFacorial(n - 1, n * f);
  }

  println(rFacorial(5, 1));
  println();


  // fibonacci series
  println("---fibonacci series---")

  def fibForm(a: Int, b: Int): Stream[Int] = a #:: fibForm(b, a + b)

  //  fibForm : (a:Int, b: Int)Stream[Int];

  val f = fibForm(1, 2);
  f.takeWhile(_ <= 10) foreach println
  println(f);
  println();

  // type of scala
  println("---type of scala---");
  val s = new String("Mitul"); // reference should used new keyword
  val i = 21; // value not contain new keyword

  println(s);
  println(i);
  println();

  //operators
  println("---operators");
  val h = 10;
  println(h);
  println(h.+(5));
  println(h.compare(10));
  println(h to 20)
  println(h.to(20));
  println();

  //ifelse
  println("---ifelse---")
  val x = 21;
  if (x == 20) println("matched")
  else println("miss matched")

  var res = if (x == 20) "matched" else "not matched"
  println(res)
  println()

  //while and do while loop
  println("---while and do while loop---")
  var res1 = 0;
  while (res1 <= 10) {
    println("res1 = " + res1);
    res1 += 1; // res1++, res1--, ++res1, --res1 not allow in scala
  }
  println();
  var res2 = 0;
  do {
    println("res2 = " + res2);
    res2 += 1;
  } while (res2 <= 5);
  println();

  // Function literals
  println("---Function literals---")
  val customers = List("mitul", "daksh", "anisha", "deep", "chirag");
  val cs = customers.map((x: String) => x.capitalize);
  println(customers);
  println(cs);
  println();

  // placeholder syntax
  println("---placeholder syntax---")
  val r = 1 to 10
  val range = r.map(x => x + 10)
  println(r)
  println(range)
  println(r.reduce((x, y) => x + y))
  println(r.reduce(_ + _)) //placeholders
  println()

  // Higher order functions
  println("---Higher order functions---")

  def intDecorator(i: Int, f: Int => String) = f(i)

  val indeco = intDecorator(5, (y: Int) => "[" + y + "]")
  println(indeco)

  //----------------------------------------
  def greensomeone(prefix: String) = {
    println("got prefix " + prefix)
    (name: String) => println(prefix + " " + name)
  }

  val hellosomeone = greensomeone("Hello")
  hellosomeone("Mitul")

  greensomeone("Hi")("Mitul")

  //----------------------------------------
  def cubes(x: Int) = {
    println("x = " + x)
    (y: Int) => println((x * x * x) + (y * y * y))
  }

  cubes(3)(5)

  //-----------------------------------------
  def sqrtfunc(x: Int) = (y: Int) => println(Math.sqrt(x + y))

  sqrtfunc(25)(75)
  println()

  //varargs, named arguments functions
  println("---varargs, named arguments functions---")

  def multiString(s: String*) = s foreach println

  multiString("one", "two", "three")
  println()
  multiString("one", "two", "three", "four")
  println()

  // partially applied functions
  println("---partially applied functions---")

  def sumOfX(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sumOfX(f, a + 1, b)
  }

  println(sumOfX(x => x, 1, 5))
  println(sumOfX(x => x * x, 1, 5))
  println(sumOfX(x => x * x * x, 1, 5))


  // curring functions
  def sumnum(x: Int, y: Int, z: Int) = x + y + z

  val s1 = sumnum(1,2,3)
  println(s1)
  println()

  // object oriented in scala
  println("---object oriented in scala---")
  class Customer(var id:Int, var name:String)

  val c = new Customer(11, "Mitul");
  println(c.id, c.name);

  c.id = 12
  c.name ="Paras"
  println(c.id, c.name);

  // constructors
  class Box(var width:Int, var height:Int, var depth:Int){
    //Auxiliary constructor
    def this()={
      this(1,1,1)
    }
    def this(w:Int, h:Int){
      this(w,h,1)
    }
    def showBox = println(s"width = $width, height = $height, depth = $depth")
  }

  val b1 = new Box();
  val b2 = new Box(2,3)
  val b3 = new Box(3,4,5)

  b1.showBox
  b2.showBox
  b3.showBox
  println()

}
