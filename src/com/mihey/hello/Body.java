package com.mihey.hello;

class Body {
    String firstName;
    String lastName;
    public Body() {
        this("Jon", "Doe");
    }

    public Body(String firstName) {

        this(firstName, "Doe");
    }

    public Body(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static void main(String[] args) {
        Body b = new Body();
        System.out.println(b.getFirstName());
        System.out.println(b.getLastName());
        System.out.println(b.getClass());
    }
}

