package uz.teacher.crazymath.model

open class Employee(var name: String, var age: Int, var salary: Int) {

    open fun showInfo() {
        print("Name: $name, Age: $age")
    }

}

class Developer(
    name: String,
    age: Int,
    salary: Int,
    var language: String,
    var level: String
) :
    Employee(name, age, salary) {

    override fun showInfo() {
        super.showInfo()
        println(" Level: $age")
        println(" Language: $language")
    }

}

class Teacher(
    name: String,
    age: Int,
    salary: Int,
    var subject: String,
    level: String
) :
    Employee(name, age, salary) {
    override fun showInfo() {
        super.showInfo()
        println(" Subject: $subject")
    }
}

class Manager(
    name: String,
    age: Int,
    salary: Int,
    var department: String,
    experience: Int
) :
    Employee(name, age, salary) {
    override fun showInfo() {
        super.showInfo()
        println(" Department: $department")
    }


}