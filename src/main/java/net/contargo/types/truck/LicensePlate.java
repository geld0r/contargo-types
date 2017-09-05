package net.contargo.types.truck;

import net.contargo.types.util.Assert;


/**
 * Each {@link net.contargo.domain.Truck} can be identified by its license plate.
 *
 * @author  Aljona Murygina - murygina@synyx.de
 * @since  0.1.0
 */
public final class LicensePlate {

    private final String normalizedValue;
    private final Country country;
    private final boolean isValid;

    /**
     * Use {@link #forValue(String)} to build a new {@link LicensePlate} instance.
     *
     * @param  value  represents a license plate
     * @param  country  the {@link Country} where the license plate is registered
     */
    private LicensePlate(String value, Country country) {

        this.normalizedValue = normalize(country, value);
        this.country = country;
        this.isValid = validate(country, normalizedValue);
    }

    private static String normalize(Country country, String rawValue) {

        return country.getLicensePlateHandler().normalize(rawValue);
    }


    private static boolean validate(Country country, String value) {

        return country.getLicensePlateHandler().validate(value);
    }


    /**
     * Build a new {@link LicensePlate} with a {@link String} value.
     *
     * @param  value  represents a license plate
     *
     * @return  {@link LicensePlateBuilder}, never {@code null}
     */
    public static LicensePlateBuilder forValue(String value) {

        Assert.notBlank(value, "Value for license plate must not be null or empty");

        return new LicensePlateBuilder(value);
    }


    /**
     * Return the {@link LicensePlate} in a formatted way.
     *
     * @return  formatted {@link LicensePlate}, never {@code null}
     */
    @Override
    public String toString() {

        return normalizedValue;
    }


    /**
     * Check if the {@link LicensePlate} is valid.
     *
     * @return  {@code true} if the {@link LicensePlate} is valid, else {@code false}
     */
    public boolean isValid() {

        return isValid;
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        String o1 = this.toString();
        String o2 = obj.toString();

        return o1.equals(o2);
    }


    @Override
    public int hashCode() {

        return this.toString().hashCode();
    }


    /**
     * Get the {@link Country} of this {@link LicensePlate}.
     *
     * @return  country, never {@code null}
     *
     * @since  0.2.0
     */
    public Country getCountry() {

        return country;
    }

    public static class LicensePlateBuilder {

        private String value;

        private LicensePlateBuilder(String value) {

            this.value = value;
        }

        /**
         * Set the {@link Country} for this {@link LicensePlate}.
         *
         * @param  country  never {@code null}
         *
         * @return  {@link LicensePlate}, never {@code null}
         *
         * @since  0.2.0
         */
        public LicensePlate withCountry(Country country) {

            Assert.notNull(country, "Country must not be null");

            return new LicensePlate(value, country);
        }
    }
}
