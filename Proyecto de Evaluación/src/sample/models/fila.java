package sample.models;

import javafx.beans.property.SimpleStringProperty;

public class fila {
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty last_name;
    private SimpleStringProperty age;
    private SimpleStringProperty email;
    private SimpleStringProperty password;
    private SimpleStringProperty img_profile;

    public fila(String id,String name,String last_name,String age, String email,String password, String img_profile){
        this.id=new SimpleStringProperty(id);
        this.name=new SimpleStringProperty(name);
        this.last_name=new SimpleStringProperty(last_name);
        this.age=new SimpleStringProperty(age);
        this.email=new SimpleStringProperty(email);
        this.password=new SimpleStringProperty(password);
        this.img_profile=new SimpleStringProperty(img_profile);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLast_name() {
        return last_name.get();
    }

    public SimpleStringProperty last_nameProperty() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name.set(last_name);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getImg_profile() {
        return img_profile.get();
    }

    public SimpleStringProperty img_profileProperty() {
        return img_profile;
    }

    public void setImg_profile(String img_profile) {
        this.img_profile.set(img_profile);
    }
}
