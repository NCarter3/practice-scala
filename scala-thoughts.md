### Write About Scala

  - What's easy to do in Scala? What's not?

  It is really easy to do list style comprehension a la racket with the concepts of `first :: second :: rest` that allows matching of the form of lists. Pattern matching in general is really easy. The ability to do very complicated case statements with variable assignments allows for interesting and novel matching characterizations.

  It seems very hard to get the right type sometime. `Option` and `Some' tend to pop up a lot and be tricky to get rid of. The safety arguments for why they are in there make sense though. It is also hard to learn some of the syntax. The collections library defines a huge number of operators that are unusual, at the least, in other languages.

  - What is/are your favorite language design choice(s) that the designers of Scala 
  made? Why?

  We like that the language is designed as a functional language, and that there is the ability to treat functions as variables and vice versa. This feature allows for very powerful composition of ideas. The design choice to have semi-colon inference is also very nice.

  We also think that ease of writing lambda functions is fantastic, especially the ability to use an `_` to represent a variable when its intention is clear.

  On that vein, the type inference system is very nice when everything starts getting incredibly complex, nested types.

  - What is/are your least favorite language design choice(s)? Why? And why do
  you think the designers made that / those choice(s)?

  The getters and setters are complicated to understand syntactically, especially when you want to override them. The designers of Scala may have done this so that you can name your functions whatever you want to.

  The complexity of the type system is hard to use. However, the designers probably wanted a very strong way to reason about the language and compile-time check, so the complexity is fairly excusable.

  - What Scala features would you like to learn more about?

  We want to learn more about apply and currying as well as traits, objects, classes, methods, functions, and their differences. Also, we find the type system very confusing and we aren't quite sure what to do with Nil and None values.