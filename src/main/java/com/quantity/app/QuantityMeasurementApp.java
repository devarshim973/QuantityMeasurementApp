
package com.quantity.app;

<<<<<<< HEAD
import com.quantity.domain.length.LengthUnit;
import com.quantity.domain.length.Quantity;
=======
import com.quantity.domain.Quantity;
import com.quantity.unit.TemperatureUnit;
>>>>>>> 2186eaad5b58fc0647e8161bcccd69b668f2a664

public class QuantityMeasurementApp {

    public static void main(String[] args) {

<<<<<<< HEAD
        System.out.println(
                new Quantity(1.0, LengthUnit.FEET)
                        .convertTo(LengthUnit.INCHES)
        );

        System.out.println(
                Quantity.add(
                        new Quantity(1.0, LengthUnit.FEET),
                        new Quantity(12.0, LengthUnit.INCHES),
                        LengthUnit.FEET)
        );

        System.out.println(
                new Quantity(36.0, LengthUnit.INCHES)
                        .equals(new Quantity(1.0, LengthUnit.YARDS))
        );

        System.out.println(
                Quantity.add(
                        new Quantity(1.0, LengthUnit.YARDS),
                        new Quantity(3.0, LengthUnit.FEET),
                        LengthUnit.YARDS)
        );

        System.out.println(
                new Quantity(2.54, LengthUnit.CENTIMETERS)
                        .convertTo(LengthUnit.INCHES)
        );
    }
}
=======
        Quantity<TemperatureUnit> temp1 =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> temp2 =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        System.out.println("Equality: " + temp1.equals(temp2));

        System.out.println("Convert 100C to F: " +
                new Quantity<>(100.0, TemperatureUnit.CELSIUS)
                        .convertTo(TemperatureUnit.FAHRENHEIT));

        try {
            temp1.add(new Quantity<>(50.0, TemperatureUnit.CELSIUS));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
>>>>>>> 2186eaad5b58fc0647e8161bcccd69b668f2a664
