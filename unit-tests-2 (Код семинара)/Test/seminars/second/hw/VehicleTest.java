package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class VehicleTest {

    private Motorcycle motorcycle;
    private Car car;

    @BeforeEach
    void setup(){
        car = new Car("Лада", "2104", 1991);
        motorcycle = new Motorcycle("ИЖ", "Планета-5", 1985);
    }

    @Test
    void CarObjectIsAlsoAnInstanceOfVehicle(){
        assertInstanceOf(Vehicle.class, car);
    }

    @Test
    void CarHasFourWheels(){
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void MotorcycleHasTwoWheels(){
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    void CarAcceleratesInTestDrivingMode(){
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void MotorcycleAcceleratesInTestDrivingMode(){
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void CarIsSlowingDown(){
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void MotorcycleIsSlowingDown(){
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}