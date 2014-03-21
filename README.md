1. Learn to use filter in guava:

   Given that you have a Person Class:
   Person{
    final String name;
    final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
   }
   And you already have a personRepository class which contains five person object:
   Person("name1", 16);
   Person("name1", 17);
   Person("name1", 18);
   Person("name", 19);
   Person("name1", 20);

   Then you have to use guava filter to filter the person who are older than 18.
   And the person who's name contains '1' character.
   And the person who satisfies the above two conditions.