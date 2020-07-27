package com.mihey.anon_classes;

public class BuilderCar {
    public static void main(String[] args) {
        Car bmw = Car.newBuilder().model("X5").tm(TM.AT).maxSpeed(300).build();
        System.out.println(bmw);
        Car audi = Car.newBuilder().model("Q7").color("blue").build();
        System.out.println(audi);
    }
}
    enum TM {    // Transmission
        AT, MT;
    }

    class Car {
        private String model;
        private int maxSpeed;
        private String color;
        private TM tm;

        private Car(Builder b) {
            this.color = b.color;
            this.maxSpeed = b.maxSpeed;
            this.model = b.model;
            this.tm = b.tm;

        }
        static  Builder newBuilder() {
            return  new Builder();
        }

        static class Builder {
            private String model;
            private int maxSpeed;
            private String color;
            private TM tm;

            public Builder() {
            }

            public Builder color(String color) {
                this.color = color;
                return this;

            }public Builder model(String model) {
                this.model = model;
                return this;

            }public Builder maxSpeed(int maxSpeed) {
                this.maxSpeed = maxSpeed;
                return this;

            }public Builder tm(TM tm) {
                this.tm = tm;
                return this;
            }
            public Car build(){
                return new Car(this);
            }
        }

        @Override
        public String toString() {
            return "Car{" +
                    "model='" + model + '\'' +
                    ", maxSpeed=" + maxSpeed +
                    ", color='" + color + '\'' +
                    ", tm=" + tm +
                    '}';
        }
    }

