package br.ufc.qxd.dsp.aula8.model;

import org.bson.Document;

public class User {

    private String name;
    private String email;
    private Integer age;

    public User(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public User(Document doc) {
        this(doc.getString("name"), doc.getString("email"), doc.getInteger("age"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public String toJson() {
        return "{name:'" + name + "', email:'" + email + "', age:" + age + "}";
    }

    public Document toDocument() { return Document.parse(this.toJson()); }

}
