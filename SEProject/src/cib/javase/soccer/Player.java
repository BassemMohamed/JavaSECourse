package cib.javase.soccer;

public class Player {
    
    int id;
    int num;
    String name;
    int age;

    public Player(int id, int num, String name, int age) {
        super();
        this.id = id;
        this.num = num;
        this.name = name;
        this.age = age;
    }

    
    public String toString() {
        return "Player: "+this.name+", with number: "+this.num+" ,has age: "+this.age;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

}
